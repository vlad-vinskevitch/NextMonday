package com.sharkit.nextmonday.main_menu.diary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sharkit.nextmonday.R;
import com.sharkit.nextmonday.configuration.widget_finder.WidgetContainer;

public class NotateFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.diary_noto, container, false);
        final WidgetContainer.DiaryNotateWidget widget = WidgetContainer.newInstance(view).getDiaryNotateWidget();


        return view;
    }
}
