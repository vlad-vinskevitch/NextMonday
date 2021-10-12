package com.sharkit.nextmonday.ui.Diary;

import static com.sharkit.nextmonday.configuration.constant.BundleTag.DATE_FOR_MAIN_DIARY_LIST;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sharkit.nextmonday.R;
import com.sharkit.nextmonday.service.diary.main_diary_service.MainDiaryService;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class MainDiary extends Fragment {
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dairy, container, false);

        MainDiaryService mainDiaryService;
        try {
            mainDiaryService = new MainDiaryService(requireArguments().getLong(DATE_FOR_MAIN_DIARY_LIST));
        } catch (IllegalStateException e) {
            mainDiaryService = new MainDiaryService(Calendar.getInstance().getTimeInMillis());
        }
        mainDiaryService.findById(root)
                .setAdaptive()
                .writeToField()
                .activity();

        return root;
    }


}
