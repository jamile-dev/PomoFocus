package io.github.jamilelima.pomofocus.Activities;

import static android.view.View.*;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import io.github.jamilelima.pomofocus.R;

public class PomodoroTimerActivity extends AppCompatActivity {

  private Toolbar mToolbar;
  TextView mTaskNameTextView;
  TextView mTextViewTimer;
  CircularProgressBar circularProgressBar;
  Button timerButton;
  Button stopButton;
  Button markDoneButton;
  CountDownTimer pomodoroTimer;

  String shortBreakText = "05:00";
  String longBreakText = "25:00";
  String pomodoroTimerText = "25:00";



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

    // BIND VARIABLES
    mTaskNameTextView = findViewById(R.id.current_task_name);
    mTaskNameTextView.setText(taskName);
    mTextViewTimer = findViewById(R.id.text_view_timer);
    timerButton = findViewById(R.id.start_or_stop_timer);
    stopButton = findViewById(R.id.stopButton);
    markDoneButton = findViewById(R.id.markDone);

    mTextViewTimer.setText(pomodoroTimerText);

    // SET BUTTON VISIBILITY
    stopButton.setVisibility(GONE);
    markDoneButton.setVisibility(GONE);


    timerButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        startOrStopPomodoroTimer(30000);
      }
    });

  }

  public void startOrStopPomodoroTimer(int duration) {
    circularProgressBar = findViewById(R.id.circularProgressBar);

    circularProgressBar.setProgressWithAnimation(100, duration);

    timerButton.setVisibility(GONE);

    stopButton.setVisibility(VISIBLE);
    markDoneButton.setVisibility(VISIBLE);

    pomodoroTimer = new CountDownTimer(	duration, 1000) {

      @Override
      public void onTick(long millisUntilFinished) {
        int seconds = (int) (millisUntilFinished / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        mTextViewTimer.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
      }

      @Override
      public void onFinish() {
        mTextViewTimer.setText(shortBreakText);
        timerButton.setVisibility(VISIBLE);
        markDoneButton.setVisibility(GONE);
        stopButton.setVisibility(GONE);
        circularProgressBar.setProgress(0);
      }
    }.start();
  }

  public void stopTimer(View view) {
    mTextViewTimer.setText(pomodoroTimerText);
    timerButton.setVisibility(VISIBLE);
    markDoneButton.setVisibility(GONE);
    stopButton.setVisibility(GONE);
    circularProgressBar.setProgress(0);
    pomodoroTimer.cancel();
  }

  public void startShortBreak() {

  }

  public void startLongBreak() {

  }

  public void markTaskDone(View view) {
    // @TODO: Implementar setar no banco de dados que a tarefa está completa
    // @TODO: Mandar tarefa para a lista de tasks feitas
    // @TODO: Marcar a tarefa como feita

    sendUserToMainActivityOnTaskDone();
  }

  public void sendUserToMainActivityOnTaskDone() {
    Intent pendingTasksList = new Intent(PomodoroTimerActivity.this, MainActivity.class);
    pendingTasksList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(pendingTasksList);
    this.finish();
  }

}
