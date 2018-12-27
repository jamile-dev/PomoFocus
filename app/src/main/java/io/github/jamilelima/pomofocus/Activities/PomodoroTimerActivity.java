package io.github.jamilelima.pomofocus.Activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import io.github.jamilelima.pomofocus.R;

public class PomodoroTimerActivity extends AppCompatActivity {

  private Toolbar mToolbar;
  TextView mTaskNameTextView;
  TextView mTextViewTimer;
  Button timerButton;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pomodoro_timer);

    mToolbar = findViewById(R.id.main_page_timer_toolbar);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setTitle(null);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    Intent taskNameByIntent = getIntent();
    String taskName = taskNameByIntent.getStringExtra("EXTRA_TASK_NAME");
    mTaskNameTextView = findViewById(R.id.current_task_name);
    mTaskNameTextView.setText(taskName);

    mTextViewTimer = findViewById(R.id.text_view_timer);
    timerButton = findViewById(R.id.start_or_stop_timer);

    timerButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startOrStopPomodoroTimer();
      }
    });
  }

  public void startOrStopPomodoroTimer() {
    new CountDownTimer(	30000, 1000) {
      @Override
      public void onTick(long millisUntilFinished) {
        int seconds = (int) (millisUntilFinished / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        mTextViewTimer.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
      }

      @Override
      public void onFinish() {
        mTextViewTimer.setText("done");
      }
    }.start();
  }

}
