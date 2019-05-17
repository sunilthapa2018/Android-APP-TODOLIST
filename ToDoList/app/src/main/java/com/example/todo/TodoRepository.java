package com.example.todo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TodoRepository {
    private TodoDao todoDao;
    private LiveData<List<Todo>> allNotes;

    public TodoRepository(Application application)
    {
        TodoDatabase database = TodoDatabase.getInstance(application);
        todoDao = database.noteDao();
        allNotes = todoDao.getAllNotes();
    }

    public void insert(Todo todo)
    {
        new InsertNoteAsyncTask(todoDao).execute(todo);
    }


    public void update(Todo todo)
    {
        new UpdateNoteAsyncTask(todoDao).execute(todo);
    }


    public void delete(Todo todo)
    {
        new DeleteNoteAsyncTask(todoDao).execute(todo);
    }

    public void deleteAllNotes()
    {
        new DeleteAllNotesAsyncTask(todoDao).execute();
    }

    public  LiveData<List<Todo>> getAllNotes()
    {
        return allNotes;
    }



    private static class InsertNoteAsyncTask extends AsyncTask<Todo,Void,Void>
    {
        private TodoDao todoDao;

        private InsertNoteAsyncTask(TodoDao todoDao)
        {
            this.todoDao = todoDao;
        }

        @Override
        protected  Void doInBackground(Todo... todos)
        {
            todoDao.insert(todos[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Todo,Void,Void>
    {
        private TodoDao todoDao;

        private UpdateNoteAsyncTask(TodoDao todoDao)
        {
            this.todoDao = todoDao;
        }

        @Override
        protected  Void doInBackground(Todo... todos)
        {
            todoDao.update(todos[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Todo,Void,Void>
    {
        private TodoDao todoDao;

        private DeleteNoteAsyncTask(TodoDao todoDao)
        {
            this.todoDao = todoDao;
        }

        @Override
        protected  Void doInBackground(Todo... todos)
        {
            todoDao.delete(todos[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private TodoDao todoDao;

        private DeleteAllNotesAsyncTask(TodoDao todoDao)
        {
            this.todoDao = todoDao;
        }

        @Override
        protected  Void doInBackground(Void... voids)
        {
            todoDao.deleteAllNotes();
            return null;
        }
    }
}
