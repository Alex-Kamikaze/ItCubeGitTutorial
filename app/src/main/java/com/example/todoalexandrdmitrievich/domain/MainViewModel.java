package com.example.todoalexandrdmitrievich.domain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.todoalexandrdmitrievich.TodoApplication;
import com.example.todoalexandrdmitrievich.data.TodoDao;
import com.example.todoalexandrdmitrievich.data.TodoEntity;

import java.util.List;

public class MainViewModel extends ViewModel {
    private TodoDao dao = TodoApplication
            .getInstance()
            .getDatabase()
            .getTodoDao();
    public LiveData<List<TodoEntity>> todos;

    public MainViewModel() {
        super();
        todos = dao.getAllTodos();
    }

    public void addTask(String todoText) {
        TodoEntity newTodo = new TodoEntity(0, todoText, false);
        dao.insertNewTodos(newTodo);
    }

    public void removeTask(TodoEntity todoEntity) {
        dao.deleteTodo(todoEntity);
    }
}
