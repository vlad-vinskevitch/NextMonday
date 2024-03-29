package com.sharkit.nextmonday.main_menu.diary.enums;

import static com.sharkit.nextmonday.main_menu.diary.transformer.DiaryTaskTransformer.toDiaryTask;
import static com.sharkit.nextmonday.main_menu.diary.transformer.DiaryTaskTransformer.toDiaryTaskDTO;

import android.content.Context;
import android.util.Log;

import com.sharkit.nextmonday.configuration.database.NextMondayDatabase;
import com.sharkit.nextmonday.main_menu.diary.domain.DiaryTask;
import com.sharkit.nextmonday.main_menu.diary.enums.impl.IDayAction;

import java.io.Serializable;
import java.util.Calendar;

public enum DayOfRepeat implements IDayAction, Serializable {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final String TAG = DayOfRepeat.class.getCanonicalName();

    @Override
    public void repeat(final DiaryTask diaryTask, final int calendarDay, final Context context) {
        final Calendar calendar = Calendar.getInstance();
        final NextMondayDatabase db = NextMondayDatabase.getInstance(context);

        calendar.setTimeInMillis(diaryTask.getTimeForRepeat());

        if (calendar.get(Calendar.DAY_OF_WEEK) == calendarDay) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1);
        } else {
            while (calendar.get(Calendar.DAY_OF_WEEK) != calendarDay) {
                calendar.add(Calendar.DAY_OF_WEEK, 1);
            }
        }

        Log.i(TAG, String.format("Repeat: %s in the day : %s", diaryTask, calendarDay));

        final DiaryTask newDiaryTask = toDiaryTask(diaryTask, calendar);
        db.dairyTaskDAO().updateRepeat(diaryTask.getId());
        db.dairyTaskDAO().create(toDiaryTaskDTO(newDiaryTask));
    }
}
