package be.formation.myapplication;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class MyApplication extends Application {

    private ArrayList<String> toDoList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyApplication", "onCreate called");
        toDoList = new ArrayList<>();
    }

    public ArrayList<String> getToDoList() {
        return toDoList;
    }
}
