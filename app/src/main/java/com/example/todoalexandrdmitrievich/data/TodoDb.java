package com.example.todoalexandrdmitrievich.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { TodoEntity.class }, version = 1)
public abstract class TodoDb extends RoomDatabase {
    public abstract TodoDao getTodoDao();
}
