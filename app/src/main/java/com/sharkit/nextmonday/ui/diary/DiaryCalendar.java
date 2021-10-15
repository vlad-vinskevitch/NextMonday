package com.sharkit.nextmonday.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sharkit.nextmonday.R;
import com.sharkit.nextmonday.service.diary.calendar_service.DiaryCalendarService;

import org.jetbrains.annotations.NotNull;

public class DiaryCalendar extends Fragment {

    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        DiaryCalendarService calendarService = new DiaryCalendarService();
        calendarService.findById(root)
                .activity()
                .writeToField()
                .setAdaptive();
        return root;
    }
}