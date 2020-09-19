package com.example.roomjson.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Details.class},version = 1)
public abstract class Details_Databse extends RoomDatabase {

    public static Details_Databse instance;
    public  abstract Detail_Dao noteDoa();

    public static synchronized Details_Databse getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Details_Databse.class, "Detail").fallbackToDestructiveMigration().build();

        }
        return instance;
    }
}
