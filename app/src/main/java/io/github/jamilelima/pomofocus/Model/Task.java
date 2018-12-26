package io.github.jamilelima.pomofocus.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {

  @PrimaryKey(autoGenerate = true)
  private int id;

  @ColumnInfo(name = "title")
  private String title;

  @ColumnInfo(name = "description")
  private String description;

  @ColumnInfo(name = "pomodoro_amount")
  private int pomodoro_amount;

  @ColumnInfo(name = "is_completed")
  private boolean isCompleted;

  public Task(String title, String description, int pomodoro_amount, boolean isCompleted) {
    this.title = title;
    this.description = description;
    this.pomodoro_amount = pomodoro_amount;
    this.isCompleted = isCompleted;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPomodoro_amount() {
    return pomodoro_amount;
  }

  public void setPomodoro_amount(int pomodoro_amount) {
    this.pomodoro_amount = pomodoro_amount;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

}
