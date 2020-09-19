package com.example.roomjson.Room;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.roomjson.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel implements ViewModelStoreOwner {
    private Detail_Repository repository;
    private LiveData<List<Details>> allDetails;
    public DetailsViewModel(@NonNull Application application) {
        super(application);
        repository=new Detail_Repository(application);
        allDetails=repository.getAllNotes();
    }

    public void insert(final Details details){

        //Creating A Request Queue
        RequestQueue requestQueue;
        // Instantiate a request queue
        requestQueue = Volley.newRequestQueue(getApplication());
        //Creating an JSonArray ReQuest
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://rkmshillong.online/public/BEG.cache", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < 20; i++) {
                        //Request Object of Volley Created
                        JSONObject obj = response.getJSONObject(i);
                        String chapno=obj.getString("chapterNo");
                        String title=obj.getString("title");
                        int items=obj.getInt("items");
                        //String id=obj.getInt("")
                        //int chap_no=obj.getInt("chapter");
                        Details details1=new Details(chapno,title,items);
                        repository.insert(details1);
                        Log.d("sucess", title.toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Something went wrong");
            }
        });
        //Request added to the Request Queue
        requestQueue.add(jsonArrayRequest);



    }
    public LiveData<List<Details>> getAllNotes(){
        return allDetails;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return null;
    }
}
