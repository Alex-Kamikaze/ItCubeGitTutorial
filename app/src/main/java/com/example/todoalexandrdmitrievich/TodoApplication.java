package com.example.todoalexandrdmitrievich;

import android.app.Application;

import androidx.room.Room;

import com.example.todoalexandrdmitrievich.data.TodoDb;

public class TodoApplication extends Application {
    public static TodoApplication Instance;
    private TodoDb database;

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
        database = Room.databaseBuilder(this,
                TodoDb.class,
                "TodoDb")
                .allowMainThreadQueries()
                .build();
    }

    public static TodoApplication getInstance() { return Instance; }
    public TodoDb getDatabase() { return database; }

}
