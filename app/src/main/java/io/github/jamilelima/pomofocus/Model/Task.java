package io.github.jamilelima.pomofocus.Model;



public class Task {

  private int id;
  private String title;
  private String description;
  private Number pomodoro_amount;
  private boolean isCompleted;

  public Task(int id, String title, String description, Number pomodoro_amount, boolean isCompleted) {
    this.id = id;
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

  public Number getPomodoro_amount() {
    return pomodoro_amount;
  }

  public void setPomodoro_amount(Number pomodoro_amount) {
    this.pomodoro_amount = pomodoro_amount;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

}
