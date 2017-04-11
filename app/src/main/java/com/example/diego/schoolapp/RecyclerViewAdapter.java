package com.example.diego.schoolapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    String [] name = { "Ironman", "Deadpool", "The Hulk", "Antman", "$Monster", "Ninja", "Monster", "zZMonster", "Spiderman",
            "Wolverine", "Zombie", "Zombie2", "Worm Zombie"};
    String [] price = {"$50","$50","$50","$50","$50","$100","$100","$100","$100","$100", "$150","$150","$150"};

    int [] myImageList = new int[] {R.drawable.ironman, R.drawable.deadpool,R.drawable.hulk, R.drawable.antman,
            R.drawable.moneymonster, R.drawable.ninja, R.drawable.purplemonster, R.drawable.sleepymonster,
            R.drawable.spiderman, R.drawable.wolverine, R.drawable.zombie, R.drawable.zombie2, R.drawable.zombieworm};

    Context context;
    LayoutInflater inflater;

    public RecyclerViewAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.avatarName.setText(name[position]);
        holder.avatar.setImageResource(myImageList[position]);
        holder.price.setText(price[position]);
        holder.buy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                StudentUser temp = new StudentUser("Metsis","Diego",100);

                if (position == 0) {
                    Toast.makeText(context, "DIEGODIEGO  "+position, Toast.LENGTH_SHORT).show();
                    //temp.updateStudentAvatar(position);
                }
//                else if(position==1){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==2){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==3){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==4){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==5){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==6){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==7){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==8){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==9){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==10){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==11){
//                    temp.updateStudentAvatar(position);
//                }
//                else if(position==12){
//                    temp.updateStudentAvatar(position);
//                }


            }
        });

    }


    @Override
    public int getItemCount() {
        return name.length;
    }
}


