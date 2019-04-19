package io.github.jamilelima.pomofocus.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.github.jamilelima.pomofocus.AppDatabase;
import io.github.jamilelima.pomofocus.Model.Task;
import io.github.jamilelima.pomofocus.R;

public class NewTaskActivity extends AppCompatActivity {

  private static final String TAG = "NewTaskActivity";

  private Toolbar newTaskToolbar;

  EditText taskTitle;
  EditText taskDescription;
  Button saveTaskButton;
  AppDatabase db;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_task);

    newTaskToolbar = findViewById(R.id.main_page_toolbar);
    setSupportActionBar(newTaskToolbar);
    getSupportActionBar().setTitle("New task");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    taskTitle = findViewById(R.id.task_title);
    taskDescription = findViewById(R.id.task_description);
    saveTaskButton = findViewById(R.id.save_task_button);

    taskTitle.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence str, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence str, int start, int before, int count) {
        if (str.toString().trim().length() == 0) {
          saveTaskButton.setVisibility(View.GONE);
        } else {
          saveTaskButton.setVisibility(View.VISIBLE);
        }
      }

      @Override
      public void afterTextChanged(Editable s) {
      }
    });

    db = Room.databaseBuilder(this, AppDatabase.class, "production").allowMainThreadQueries()
        .build();
  }

  public void saveTask(View view) {

    final String title = taskTitle.getText().toString();
    final String description = taskDescription.getText().toString();
    final int pomodoro_amount = 4;
    final boolean is_completed = false;

    db.taskDao().insertAll(new Task(
        title,
        description,
        pomodoro_amount,
        is_completed
    ));

    Intent mainActivityIntent = new Intent(NewTaskActivity.this, MainActivity.class);
    mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(mainActivityIntent);
    this.finish();

  }
}
