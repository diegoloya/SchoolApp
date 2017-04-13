package com.example.diego.schoolapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.content.Intent;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.example.diego.schoolapp.R.id.imageView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    //FirebaseUser user = mAuth.getCurrentUser();
    int points=0;



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
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase.child(user.getUid()).child("points").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int pts = dataSnapshot.getValue(int.class);
                points=pts;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        holder.buy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (position == 0) {
                    if (points>=50) {
                        mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                        points-=50;
                        mDatabase.child(user.getUid()).child("points").setValue(points);
                    }
                    else{
                        Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                    }
                }
                else if(position==1) {
                    if (points >= 50) {
                        //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        mDatabase = FirebaseDatabase.getInstance().getReference();
                        mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                        points-=50;
                        mDatabase.child(user.getUid()).child("points").setValue(points);
                    } else {
                        Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                    }
                }
                else if(position==2) {
                        if (points >= 50) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=50;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==3) {
                        if (points >= 50) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=50;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==4) {
                        if (points >= 50) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=50;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }


                else if(position==5) {
                        if (points >= 100) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=100;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==6) {
                        if (points >= 100) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=100;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==7) {
                        if (points >= 100) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=100;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==8) {
                        if (points >= 100) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=100;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==9) {
                        if (points >= 100) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=100;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==10) {
                        if (points >= 150) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=150;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==11) {
                        if (points >= 150) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=150;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }
                else if(position==12) {
                        if (points >= 150) {
                            //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child(user.getUid()).child("imageID").setValue(myImageList[position]);
                            points-=150;
                            mDatabase.child(user.getUid()).child("points").setValue(points);
                        } else {
                            Toast.makeText(context, "Not enough $money$!!", Toast.LENGTH_LONG).show();
                        }
                    }



            }


        });

    }


    @Override
    public int getItemCount() {
        return name.length;
    }
}


