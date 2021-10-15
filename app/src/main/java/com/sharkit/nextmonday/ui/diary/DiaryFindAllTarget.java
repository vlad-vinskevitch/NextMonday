package com.sharkit.nextmonday.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sharkit.nextmonday.R;
import com.sharkit.nextmonday.service.diary.all_list_of_target.ListOfTargetService;

import org.jetbrains.annotations.NotNull;

public class DiaryFindAllTarget extends Fragment {
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dairy_three, container, false);
        ListOfTargetService service = new ListOfTargetService();
        service.findById(root)
                .writeToField()
                .activity()
                .setAdaptive();
        return root;
    }
}