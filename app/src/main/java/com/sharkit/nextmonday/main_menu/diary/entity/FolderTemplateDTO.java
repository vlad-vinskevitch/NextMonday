package com.sharkit.nextmonday.main_menu.diary.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(tableName = "diary_folder_template")
public class FolderTemplateDTO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Integer templateId;

    @ColumnInfo(name = "folder_name")
    private String name;
}
