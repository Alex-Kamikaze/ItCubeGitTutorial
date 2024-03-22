package com.example.todoalexandrdmitrievich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.todoalexandrdmitrievich.data.TodoEntity;
import com.example.todoalexandrdmitrievich.databinding.ActivityMainBinding;
import com.example.todoalexandrdmitrievich.domain.MainViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel viewModel;
    ArrayList<String> todos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Это главный экран в приложении
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.addTask.setOnClickListener(v -> {
            String taskText = binding.taskInput.getText().toString();
            if(!taskText.equals("")) {
                viewModel.addTask(taskText);
            }
        });

        ArrayAdapter<String> todoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                todos);
        viewModel.todos.observe(this, todoEntities -> {
            todoEntities.forEach(todoEntity -> {
                todos.add(todoEntity.todoText);
            });
            todoAdapter.notifyDataSetChanged();
        });
        binding.taskList.setOnItemClickListener((parent, view, position, id) -> {
            viewModel.removeTask(viewModel.todos.getValue().get(position));
        });
    }
}