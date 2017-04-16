package com.example.diego.schoolapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.Iterator;


public class ViewClassActivity extends AppCompatActivity {
    private String teacherRef;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    ArrayList<UserDB> entries = new ArrayList<>();
    RecyclerView recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class);
        Bundle bundle = getIntent().getExtras();
        teacherRef = bundle.getString("stuff");

        recyclerview=(RecyclerView) findViewById(R.id.recyclerViewView);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        mDatabase = FirebaseDatabase.getInstance().getReference();

//        String name = "goku";
//        int image = 2130837614;
//        String points = "123";
//        UserDB entry = new UserDB(image,name,points);
//
//        entries.add(entry);

        getUsers();

//        RecUsersAdapter adapter=new RecUsersAdapter(this,entries);
//        recyclerview.setAdapter(adapter);



    }



private void getUsers(){
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    mDatabase = FirebaseDatabase.getInstance().getReference();
    mDatabase.orderByChild("teacher").equalTo(teacherRef).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                        entries.clear();
                        while  (items.hasNext()) {

                            DataSnapshot item = items.next();
                            Toast.makeText(ViewClassActivity.this,"IN HERE", Toast.LENGTH_SHORT).show();

//                            String name="diego";
//                            String points="points";
//                            int image=2130837614;
                            String name,points;
                            int image;
                            name = item.child("studentName").getValue().toString();
                            image = item.child("imageID").getValue(int.class);
                            points = item.child("points").getValue().toString();
                            UserDB entry = new UserDB(image,name,points);
                            entries.add(entry);
                        }

                                RecUsersAdapter adapter=new RecUsersAdapter(ViewClassActivity.this,entries);
                                recyclerview.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                }

        );
    }
}



