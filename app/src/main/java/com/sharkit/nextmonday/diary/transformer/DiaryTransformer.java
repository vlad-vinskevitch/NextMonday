package com.sharkit.nextmonday.diary.transformer;

import com.sharkit.nextmonday.configuration.widget_finder.widget.EditTextWidget;
import com.sharkit.nextmonday.diary.entity.DiaryTask;
import com.sharkit.nextmonday.diary.entity.TaskOfDay;
import com.sharkit.nextmonday.diary.service.DiaryCreateTaskService;
import com.sharkit.nextmonday.diary.service.DiaryUpdateTaskService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DiaryTransformer {

    public static DiaryTask toDiaryTask(DiaryCreateTaskService service, EditTextWidget widget, Calendar calendar){
        return DiaryTask.builder()
                .daysOfAlarm(service.getDaysOfAlarm())
                .date(SimpleDateFormat.getDateInstance().format(calendar.getTimeInMillis()))
                .week(calendar.get(Calendar.WEEK_OF_YEAR))
                .hour(service.getHour())
                .minute(service.getMinute())
                .nameOfTask(widget.getNameOfTask().getText().toString())
                .description(widget.getDescription().getText().toString())
                .build();
    }
    public static DiaryTask toDiaryTask(DiaryUpdateTaskService service, EditTextWidget widget, DiaryTask diaryTask){
        return DiaryTask.builder()
                .daysOfAlarm(service.getDaysOfAlarm())
                .date(diaryTask.getDate())
                .week(diaryTask.getWeek())
                .hour(service.getHour())
                .minute(service.getMinutes())
                .nameOfTask(widget.getNameOfTask().getText().toString())
                .description(widget.getDescription().getText().toString())
                .build();
    }

    public static TaskOfDay toTaskOfDay(List<DiaryTask> diaryTasks, Calendar calendar){
        return TaskOfDay.builder()
                .timeInMillis(calendar.getTimeInMillis())
                .diaryTasks(diaryTasks)
                .build();
    }

}
