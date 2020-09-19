package com.example.roomjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.roomjson.Room.Details;
import com.example.roomjson.Room.DetailsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public  DetailsViewModel detailsViewModel;
    RecyclerView recyclerView;
    Details details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter();

        //Creating the viewModel
        detailsViewModel= new DetailsViewModel(getApplication());
        detailsViewModel.getAllNotes().observe(this, new Observer<List<Details>>() {
            @Override
            public void onChanged(List<Details> listDetails) {
                recyclerviewAdapter.setDetails(listDetails);
                detailsViewModel.insert(details);
            }
        });


    }
}