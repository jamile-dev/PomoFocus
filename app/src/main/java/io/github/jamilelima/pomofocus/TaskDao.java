package io.github.jamilelima.pomofocus;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import io.github.jamilelima.pomofocus.Model.Task;
import java.util.List;

@Dao
public interface TaskDao {

  @Query("SELECT * FROM task WHERE is_completed LIKE 1")
  List<Task> getDoneTasks();

  @Query("SELECT * FROM task WHERE is_completed LIKE 0")
  List<Task> getUndoneTasks();

  @Insert
  void insertAll(Task... task);

  @Query("UPDATE task SET is_completed  = :isCompleted WHERE id = :id")
  void setCompleted(boolean isCompleted, int id);

}
