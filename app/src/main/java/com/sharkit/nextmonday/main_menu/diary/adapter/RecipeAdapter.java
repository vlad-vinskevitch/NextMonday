package com.sharkit.nextmonday.main_menu.diary.adapter;

import static com.sharkit.nextmonday.main_menu.diary.transformer.recipe.RecipeItemTransformer.toRecipeItemDTO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sharkit.nextmonday.R;
import com.sharkit.nextmonday.configuration.database.NextMondayDatabase;
import com.sharkit.nextmonday.main_menu.diary.configuration.widget.WidgetContainer;
import com.sharkit.nextmonday.main_menu.diary.dialog.DialogRecipeFood;
import com.sharkit.nextmonday.main_menu.diary.domain.template.recipe.RecipeItem;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecipeAdapter extends BaseAdapter {

    private final List<RecipeItem> items;
    private final Context context;

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(final int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(this.context).inflate(R.layout.diary_noto_recipe_item, null);

        final WidgetContainer.DiaryNotateRecipeWidget.RecipeItemWidget widget = WidgetContainer.newInstance(convertView).getDiaryNotateRecipeWidget().getRecipeItemWidget();

        widget.getDescription().setText(this.items.get(position).getDescription());
        widget.getName().setText(this.items.get(position).getName());
        widget.getItem().setOnCreateContextMenuListener((menu, v, menuInfo) -> this.createMenuListener(menu, this.context, position));
        return convertView;
    }

    private void createMenuListener(final ContextMenu menu, final Context context, final int position) {
        menu.add(context.getString(R.string.button_change))
                .setOnMenuItemClickListener(item -> {
                    new DialogRecipeFood(context, this.items.get(position).getTemplateId(), this.items, RecipeAdapter.this)
                            .changeItem(this.items.get(position), position);
                    return true; });
        menu.add(context.getString(R.string.button_delete))
                .setOnMenuItemClickListener(item -> {
                    NextMondayDatabase.getInstance(context).recipeItemDAO().delete(toRecipeItemDTO(this.items.get(position)));
                    this.items.remove(position);
                    this.notifyDataSetChanged();
                    return true; });
    }
}
