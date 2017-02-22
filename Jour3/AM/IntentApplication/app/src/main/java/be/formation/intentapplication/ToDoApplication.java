package be.formation.intentapplication;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ToDoApplication extends Application {

    private List<String> toDoList;

    @Override
    public void onCreate() {
        super.onCreate();
        toDoList = new ArrayList<>();
    }

    public void addToDoItem(String item) {
        toDoList.add(item);
    }

    public String getAllItemsAsString() {
        StringBuilder sb = new StringBuilder();
        for (String s : toDoList) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
