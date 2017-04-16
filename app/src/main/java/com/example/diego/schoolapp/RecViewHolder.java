package com.example.diego.schoolapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RecViewHolder extends RecyclerView.ViewHolder {

    ImageView avatar;
    TextView studentName;
    TextView points;

    public RecViewHolder(View itemView) {
        super(itemView);

        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        studentName = (TextView) itemView.findViewById(R.id.studentName);
        points = (TextView) itemView.findViewById(R.id.studentPoints);
    }
}
