package com.example.roomjson.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface Detail_Dao {

    @Insert
    void insert(Details details);

    @Query("Select * From details_table Order by items desc")
    LiveData<List<Details>> getAllNotes();
}
