package com.example.todo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private TodoRepository repository;
    private LiveData<List<Todo>> allNotes;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert (Todo todo)
    {
        repository.insert(todo);
    }

    public void update(Todo todo)
    {
        repository.update(todo);
    }

    public void delete(Todo todo)
    {
        repository.delete(todo);
    }

    public void deleteAllNotes()
    {
        repository.deleteAllNotes();
    }
    public  LiveData<List<Todo>> getAllNotes()
    {
        return allNotes;
    }
}
