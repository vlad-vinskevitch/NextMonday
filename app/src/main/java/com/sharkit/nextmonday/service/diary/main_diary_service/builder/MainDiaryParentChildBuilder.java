package com.sharkit.nextmonday.service.diary.main_diary_service.builder;

import android.view.View;

import com.sharkit.nextmonday.entity.diary.ParentItemData;
import com.sharkit.nextmonday.service.builder.LayoutParentBuild;
import com.sharkit.nextmonday.service.diary.main_diary_service.ParentService;

public class MainDiaryParentChildBuilder implements LayoutParentBuild {
    private final ParentService parentService;

    public MainDiaryParentChildBuilder(ParentItemData parentItemData) {
        parentService = new ParentService(parentItemData);
    }

    @Override
    public LayoutParentBuild writeToField() {
        parentService.writeToField();
        return this;
    }

    @Override
    public LayoutParentBuild findById(View root) {
        parentService.findById(root);
        return this;
    }

    @Override
    public LayoutParentBuild setAdaptive() {
        parentService.setAdaptive();
        return this;
    }

    @Override
    public LayoutParentBuild activity() {
        parentService.activity();
        return this;
    }

    @Override
    public ParentService build() {
        return parentService;
    }
}