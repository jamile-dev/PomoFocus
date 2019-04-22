package io.github.jamilelima.pomofocus.scenes.pomodoroTimer

import android.view.View.*

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import io.github.jamilelima.pomofocus.AppDatabase
import io.github.jamilelima.pomofocus.R
import io.github.jamilelima.pomofocus.scenes.main.MainActivity
import kotlinx.android.synthetic.main.activity_pomodoro_timer.*

class PomodoroTimerActivity : AppCompatActivity() {

    private lateinit var circularProgressBar: CircularProgressBar
    private lateinit var pomodoroTimer: CountDownTimer
    internal var taskId = 0

    private lateinit var db: AppDatabase

    private var shortBreakText = "05:00"
    private var longBreakText = "25:00"
    private var pomodoroTimerText = "25:00"
    private var timeOfBreak = ""

    private val totalOfPomodoros: Int
        get() = db.taskDao().getPomodoroAmount(taskId)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomodoro_timer)
        this.setSupportToActionBar()

        val taskName = intent.getStringExtra("EXTRA_TASK_NAME")
        taskId = intent.getIntExtra("EXTRA_TASK_ID", 0)

        current_task_name.text = taskName
        text_view_timer.text = pomodoroTimerText

        stopButton.visibility = GONE
        markDone.visibility = GONE

        db = Room.databaseBuilder(this, AppDatabase::class.java, "production").allowMainThreadQueries().build()

        start_or_stop_timer.setOnClickListener { startOrStopPomodoroTimer(1500000) }

    }

    private fun setSupportToActionBar() {
        setSupportActionBar(main_page_timer_toolbar as Toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun startOrStopPomodoroTimer(duration: Int) {
        circularProgressBar = findViewById(R.id.circularProgressBar)

        circularProgressBar.setProgressWithAnimation(100f, duration)

        start_or_stop_timer.visibility = GONE

        stopButton.visibility = VISIBLE
        markDone.visibility = VISIBLE

        pomodoroTimer = object : CountDownTimer(duration.toLong(), 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var seconds = (millisUntilFinished / 1000).toInt()
                val minutes = seconds / 60
                seconds %= 60
                text_view_timer.text = "${String.format("%02d", minutes)}:${String.format("%02d", seconds)}"
            }

            override fun onFinish() {
                text_view_timer.text = shortBreakText
                start_or_stop_timer.visibility = VISIBLE
                markDone.visibility = GONE
                stopButton.visibility = GONE
                circularProgressBar.progress = 0f
            }
        }.start()
    }

    fun stopTimer(view: View) {
        text_view_timer.text = pomodoroTimerText
        start_or_stop_timer.visibility = VISIBLE
        markDone.visibility = GONE
        stopButton.visibility = GONE
        circularProgressBar.progress = 0f
        pomodoroTimer.cancel()
    }

    fun startShortBreak() {}

    fun startLongBreak() {}

    fun endACycleOfPomodoro() {
        db.taskDao().setCompleted(true, taskId)
    }


    fun markTaskDone(view: View) {
        db.taskDao().setCompleted(true, taskId)

        setAndReturnTotalOfPomodoros()

        sendUserToMainActivityOnTaskDone()
    }

    private fun sendUserToMainActivityOnTaskDone() {
        val pendingTasksList = Intent(this@PomodoroTimerActivity, MainActivity::class.java)
        pendingTasksList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(pendingTasksList)
        this.finish()
    }

    private fun setAndReturnTotalOfPomodoros(): Int {
        val actualTotalOfPomodoros = totalOfPomodoros
        val newTotalOfPomodoros = actualTotalOfPomodoros + 1
        db.taskDao().setPomodoroAmount(newTotalOfPomodoros, taskId)
        return newTotalOfPomodoros
    }

}
