package io.github.jamilelima.pomofocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class NewTaskActivity extends AppCompatActivity {

    private Toolbar newTaskToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        newTaskToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(newTaskToolbar);
        getSupportActionBar().setTitle("New task");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


}
