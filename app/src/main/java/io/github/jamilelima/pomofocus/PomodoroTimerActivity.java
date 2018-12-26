package io.github.jamilelima.pomofocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class PomodoroTimerActivity extends AppCompatActivity {

  private Toolbar mToolbar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pomodoro_timer);

    mToolbar = findViewById(R.id.main_page_timer_toolbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setTitle("Pomo Timer");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
  }
}
