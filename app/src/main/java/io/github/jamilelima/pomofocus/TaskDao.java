package io.github.jamilelima.pomofocus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import io.github.jamilelima.pomofocus.Model.Task;
import java.util.List;

@Dao
public interface TaskDao {

  @Query("SELECT * FROM task")
  List<Task> getAllTasks();

  @Insert
  void insertAll(Task... task);

}
