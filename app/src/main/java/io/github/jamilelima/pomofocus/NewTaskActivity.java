package io.github.jamilelima.pomofocus;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.github.jamilelima.pomofocus.Model.Task;

public class NewTaskActivity extends AppCompatActivity {

  private static final String TAG = "NewTaskActivity";

    private Toolbar newTaskToolbar;

    EditText taskTitle;
    EditText taskDescription;
    Button saveTaskButton;


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

    }

    public void saveTask(View view) {

      final AppDatabase db = Room
          .databaseBuilder(this, AppDatabase.class, "production").allowMainThreadQueries().build();

      final String title = taskTitle.getText().toString();
      final String description = taskDescription.getText().toString();
      final int pomodoro_amount = 4;
      final boolean is_completed = false;

      saveTaskButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          db.taskDao().insertAll(new Task(
              title,
              description,
              pomodoro_amount,
              is_completed
          ));

          startActivity(new Intent(NewTaskActivity.this, MainActivity.class));
        }
      });
    }


}
