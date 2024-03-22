package com.example.todoalexandrdmitrievich.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    public int todoId;

    @ColumnInfo(name = "todoText")
    public String todoText;

    @ColumnInfo(name = "todoCompleted")
    public Boolean todoCompleted;

    public TodoEntity(int todoId, String todoText, Boolean todoCompleted) {
        this.todoId = todoId;
        this.todoText = todoText;
        this.todoCompleted = todoCompleted;
    }
}
