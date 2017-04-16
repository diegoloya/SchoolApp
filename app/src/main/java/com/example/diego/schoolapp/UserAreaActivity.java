package com.example.diego.schoolapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
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


public class UserAreaActivity extends AppCompatActivity {
    Button bSignOut;
    Button checkIn;
    Button shop;
    Button viewClass;
    TextView userName;
    TextView points;
    ImageView avatar;
    TextView teacherName;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabase;
    private String teacherRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        mAuth = FirebaseAuth.getInstance();
        checkIn = (Button) findViewById(R.id.bCheckIn);

        shop = (Button) findViewById(R.id.bShop);
        viewClass = (Button) findViewById(R.id.bViewClass);

        userName = (TextView) findViewById(R.id.editTextName);
        points = (TextView) findViewById(R.id.editTextPoints);
        avatar = (ImageView) findViewById(R.id.imageView);
        teacherName = (TextView) findViewById(R.id.editTextTeacher);



        FirebaseUser user = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();                                  //!!!!!!!
        mDatabase.child(user.getUid()).child("studentName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                userName.setText(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child(user.getUid()).child("points").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pts = dataSnapshot.getValue(int.class).toString();
                points.setText(pts);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase.child(user.getUid()).child("teacher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String teacher = dataSnapshot.getValue(String.class);
                teacherRef=teacher;
                teacherName.setText(teacher);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mDatabase.child(user.getUid()).child("imageID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int imageID = dataSnapshot.getValue(int.class);
                //Toast.makeText(UserAreaActivity.this, "Number:" + imageID, Toast.LENGTH_SHORT).show();

                avatar.setImageResource(imageID);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        checkIn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(new Intent(UserAreaActivity.this, CheckInActivity.class));
//            }
//        });
        shop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(UserAreaActivity.this, ShopActivity.class));
            }
        });
        viewClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(UserAreaActivity.this, ViewClassActivity.class));
                Intent i = new Intent(UserAreaActivity.this, ViewClassActivity.class);
                String getrec=teacherRef;
                Toast.makeText(UserAreaActivity.this, ""+teacherRef, Toast.LENGTH_SHORT).show();

//Create the bundle
                Bundle bundle = new Bundle();

//Add your data to bundle
                bundle.putString("stuff", getrec);

//Add the bundle to the intent
                i.putExtras(bundle);

//Fire that second activity
                startActivity(i);
            }
        });


        bSignOut = (Button) findViewById(R.id.bSignOut);
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                if(firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(UserAreaActivity.this, LoginActivity.class));
                }
            }
        };


        bSignOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signOut();
            }
        });
    }


    private void signOut() {
        // Firebase sign out
        mAuth.signOut();
        startActivity(new Intent(UserAreaActivity.this, LoginActivity.class));
    }

    public void onDataChange(DataSnapshot dataSnapshot){
        String text = dataSnapshot.getValue(String.class);
        userName.setText(text);
    }

}
