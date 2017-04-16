package com.example.diego.schoolapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diego.schoolapp.UserDB;
import com.example.diego.schoolapp.R;


import java.util.ArrayList;

public class RecUsersAdapter extends RecyclerView.Adapter<RecViewHolder> {

//
//    private Context context;
//    private ArrayList<UserDB> entries;
//    public LayoutInflater inflater;
//
//    public RecUsersAdapter(Context context, ArrayList<UserDB> entries) {
//        this.context = context;
//        this.entries = entries;
//        inflater=LayoutInflater.from(context);
//    }
//
//    @Override
//    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = inflater.inflate(R.layout.user_row, parent,false);
//        RecViewHolder viewHolder = new RecViewHolder(v);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecViewHolder holder, int position) {
//        UserDB user = entries.get(position);
//        holder.avatar.setImageResource(user.image);
//        holder.points.setText(user.points);
//        holder.studentName.setText(user.name);
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return entries.size();
//    }

    Context context;
    ArrayList<UserDB> entries;

    public RecUsersAdapter(Context context, ArrayList<UserDB> entries) {
        this.context = context;
        this.entries = entries;
    }
    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_row, parent,false);
        return new RecViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
//        UserDB user = entries.get(position);
//        holder.avatar.setImageResource(user.getImage());
//        holder.points.setText(user.getPoints());
//        holder.studentName.setText(user.getName());
        holder.studentName.setText(entries.get(position).getName());
        holder.points.setText(entries.get(position).getPoints());
        holder.avatar.setImageResource(entries.get(position).getImage());
    }
    @Override
    public int getItemCount(){
        return entries.size();
    }





}