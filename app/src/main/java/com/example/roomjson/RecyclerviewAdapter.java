package com.example.roomjson;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomjson.Room.Details;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewholder> {

   Activity context;
   List<Details> detailsArrayList=new ArrayList<>() ;

   //Constructor of the Recycler view takes two parameters context and Arraylist of generic type Details
//    public RecyclerviewAdapter(Activity context, ArrayList<Details> userArrayList) {
//        this.context = context;
//        this.detailsArrayList = userArrayList;
//    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        //Creating a details object
        Details details=detailsArrayList.get(position);

        //Binding each item to its position
        holder.txtitme.setText(details.getItems());
        holder.txtid.setText(details.getId());
        holder.txtchapno.setText(details.getChapter_no());
        holder.txttitle.setText(details.getTitle());
    }

    //getting all the details when the states changes
    public void setDetails(List<Details> details){
        this.detailsArrayList=details;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return detailsArrayList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
            private TextView txtid,txtchapno,txtitme,txttitle;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            txtid=itemView.findViewById(R.id.txt_id);
            txtchapno=itemView.findViewById(R.id.txt_chapno);
            txttitle=itemView.findViewById(R.id.txt_title);
            txtitme=itemView.findViewById(R.id.txt_items);
        }
    }
}
