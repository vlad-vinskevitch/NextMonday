package com.sharkit.nextmonday.main_menu.diary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sharkit.nextmonday.main_menu.diary.domain.Notate;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotateAdaptor extends BaseAdapter {

    private final List<Notate> notates;
    private final Context context;

    @Override
    public int getCount() {
        return this.notates.size();
    }

    @Override
    public Object getItem(final int position) {
        return this.notates.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View view = this.notates.get(position).getTemplateType().getView(this.context);

        this.notates.get(position).getTemplateType().setAction(view, this.notates.get(position));

        return view;
    }
}


