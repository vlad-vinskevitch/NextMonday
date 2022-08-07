package com.sharkit.nextmonday.main_menu.diary.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.sharkit.nextmonday.main_menu.diary.entity.RecipeItemDTO;

@Dao
public interface RecipeItemDAO {

    @Insert
    void save(RecipeItemDTO itemDTO);

    @Delete
    void delete(RecipeItemDTO itemDTO);

    @Update
    void update(RecipeItemDTO itemDTO);
}
