package com.example.todoalexandrdmitrievich.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert
    void insertNewTodos(TodoEntity... todos);

    @Update
    void updateTodo(TodoEntity todo);

    @Delete
    void deleteTodo(TodoEntity todo);


    @Query("SELECT * FROM todoentity")
    LiveData<List<TodoEntity>> getAllTodos();
}
