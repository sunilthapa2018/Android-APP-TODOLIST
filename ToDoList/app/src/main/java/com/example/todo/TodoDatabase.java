package com.example.todo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {
    private static TodoDatabase instance;

    public abstract TodoDao noteDao();

    public static synchronized TodoDatabase getInstance(Context context)
    {
        if (instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    TodoDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private  static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private TodoDao todoDao;

        private  PopulateDbAsyncTask(TodoDatabase db)
        {
            todoDao = db.noteDao();
        }

        @Override
        protected  Void doInBackground(Void...voids)
        {
            todoDao.insert(new Todo("Watch Movies", "Movies",1));
            todoDao.insert(new Todo("Play Games", "Games",1));
            todoDao.insert(new Todo("Read Book", "Books",3));
            todoDao.insert(new Todo("Watch Tv", "Tv",2));
            todoDao.insert(new Todo("Buy Groceries", "Groceries",3));
            return null;

        }
    }


}
