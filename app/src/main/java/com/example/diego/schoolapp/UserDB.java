package com.example.diego.schoolapp;

public class UserDB {
    public String name;
    public int image;
    public String points;

    public UserDB(int image, String name, String points) {
        this.name = name;
        this.image = image;
        this.points=points;
    }
    public String getName(){
        return this.name;
    }
    public String getPoints(){
        return this.points;
    }
    public int getImage(){
        return this.image;
    }
}
