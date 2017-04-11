package com.example.diego.schoolapp;
import android.app.Application;
//import com.firebase.client.firebase;

/**
 * Created by diego on 3/24/17.
 */

public class FireApp extends Application {

    private String globalTeacher;

    public String globalTeacher() {
        return globalTeacher;
    }

    public void globalTeacher(String str) {
        globalTeacher = str;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }
}
