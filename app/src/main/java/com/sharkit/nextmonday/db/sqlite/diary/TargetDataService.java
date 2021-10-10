package com.sharkit.nextmonday.db.sqlite.diary;

import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.APRIL;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.AUGUST;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.DECEMBER;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.FEBRUARY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.FRIDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.JANUARY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.JULY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.JUNE;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.MARCH;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.MAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.MONDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.NOVEMBER;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.OCTOBER;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.SATURDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.SEPTEMBER;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.SUNDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.THURSDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.TUESDAY;
import static com.sharkit.nextmonday.configuration.constant.DayAndMonth.WEDNESDAY;

import android.annotation.SuppressLint;
import android.content.Context;

import com.sharkit.nextmonday.entity.diary.DayTargets;
import com.sharkit.nextmonday.entity.diary.ParentItemData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TargetDataService implements TargetServiceMethod{
    private final TargetData targetData;
    public TargetDataService(Context context) {
        targetData = new TargetData(context);
        targetData.onCreate(targetData.getReadableDatabase());
    }

    @SuppressLint("SimpleDateFormat")
    public ArrayList<DayTargets> getWeekList() {
        ArrayList<DayTargets> targets = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        for (int i = 0; i < 7; i++) {
            DayTargets dayTargets = new DayTargets();
            ParentItemData parentItemData = new ParentItemData();
            parentItemData.setDay(getNameOfDay(calendar.get(Calendar.DAY_OF_WEEK)));
            parentItemData.setMonth(getNameOfMonth(calendar.get(Calendar.MONTH)));
            parentItemData.setNumber(calendar.get(Calendar.DATE));
            parentItemData.setCompleteTargets(targetData.getCompleteTarget(new SimpleDateFormat("dd.MM.yyyy")
                    .format(calendar.getTimeInMillis())));
            dayTargets.setParentItemData(parentItemData);
            dayTargets.setTargetDTOs(targetData.
                    findAllByDate(new SimpleDateFormat("dd.MM.yyyy")
                            .format(calendar.getTimeInMillis())));
            parentItemData.setAllTargets(dayTargets.getTargetDTOs().size());
            targets.add(dayTargets);

            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        return targets;
    }

    private String getNameOfMonth(int month) {
        switch (month) {
            case 1:
                return JANUARY;
            case 2:
                return FEBRUARY;
            case 3:
                return MARCH;
            case 4:
                return APRIL;
            case 5:
                return MAY;
            case 6:
                return JULY;
            case 7:
                return JUNE;
            case 8:
                return AUGUST;
            case 9:
                return SEPTEMBER;
            case 10:
                return OCTOBER;
            case 11:
                return NOVEMBER;
            case 12:
                return DECEMBER;
        }
        return null;
    }
    private String getNameOfDay(int day) {
        switch (day) {
            case 1:
                return SUNDAY;
            case 2:
                return MONDAY;
            case 3:
                return TUESDAY;
            case 4:
                return WEDNESDAY;
            case 5:
                return THURSDAY;
            case 6:
                return FRIDAY;
            case 7:
                return SATURDAY;
        }
        return null;
    }


}