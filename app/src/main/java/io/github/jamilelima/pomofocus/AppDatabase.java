package io.github.jamilelima.pomofocus;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import io.github.jamilelima.pomofocus.Model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  public abstract TaskDao taskDao();
}
