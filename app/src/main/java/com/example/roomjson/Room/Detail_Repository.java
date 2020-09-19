package com.example.roomjson.Room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Detail_Repository {
    Detail_Dao detail_dao;
    LiveData<List<Details>> alldetails;

    //Constructor

    public Detail_Repository(Application application){
        Details_Databse database=Details_Databse.getInstance(application);
        detail_dao=database.noteDoa();
        alldetails=detail_dao.getAllNotes();
    }

    public void insert(Details details){
        new InsertNoteAsyncTask(detail_dao).execute(details);
    }



    public LiveData<List<Details>> getAllNotes(){
        return alldetails;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Details,Void,Void> {

        private Detail_Dao detail_dao;
        private InsertNoteAsyncTask(Detail_Dao detail_dao){
            this.detail_dao=detail_dao;
        }

        @Override
        protected Void doInBackground(Details... details) {
            detail_dao.insert(details[0]);
            return null;
        }
    }

}
