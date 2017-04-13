package com.example.diego.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by diego on 4/10/17.
 */

public class StudentUser {

    private FirebaseAuth mAuth;

//    int [] myImageList = new int[] {R.drawable.missing, R.drawable.ironman, R.drawable.deadpool,R.drawable.hulk, R.drawable.antman,
//            R.drawable.moneymonster, R.drawable.ninja, R.drawable.purplemonster, R.drawable.sleepymonster,
//            R.drawable.spiderman, R.drawable.wolverine, R.drawable.zombie, R.drawable.zombie2, R.drawable.zombieworm};

    public String studentName;
    public String teacher;
    public int points;
    public int imageID;

    public StudentUser(){
    }

//    public void updateStudentAvatar(int position){
//        //Toast.makeText(this, "IM IN HERE " +position , Toast.LENGTH_SHORT).show();
//        avatar.setImageResource(R.drawable.ironman);
//        FirebaseUser user = mAuth.getCurrentUser();
//        DatabaseReference databaseReference;
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//        databaseReference.child(teacher).child(user.getUid()).setValue("Image");
//    }



    public StudentUser(String name,String teacher,int points, int imageID){
        this.studentName=name;
        this.teacher=teacher;
        this.points=points;
        this.imageID=imageID;
    }
}
