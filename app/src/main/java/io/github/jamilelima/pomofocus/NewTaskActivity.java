package io.github.jamilelima.pomofocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
      saveTaskButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          // TODO: Implementing save task on database
          Log.d(TAG, "Clicked button save task");
        }
      });
    }


}
