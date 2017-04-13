package com.example.diego.schoolapp;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView avatarName;
    TextView price;
    ImageView avatar;
    Button buy;


    public RecyclerViewHolder(View itemView){
        super(itemView);
        buy = (Button) itemView.findViewById(R.id.bBuy);
        avatarName = (TextView) itemView.findViewById(R.id.avatarName);
        price = (TextView) itemView.findViewById(R.id.price);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);

    }
}
