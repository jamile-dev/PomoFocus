package io.github.jamilelima.pomofocus.scenes.newTask

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import io.github.jamilelima.pomofocus.AppDatabase
import io.github.jamilelima.pomofocus.model.Task
import io.github.jamilelima.pomofocus.R
import io.github.jamilelima.pomofocus.scenes.main.MainActivity
import kotlinx.android.synthetic.main.activity_new_task.*

class NewTaskActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_task)
        this.setSupportToActionBar()


        task_title.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(str: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {
                if (str.toString().trim { it <= ' ' }.isEmpty()) {
                    save_task_button.visibility = View.GONE
                } else {
                    save_task_button.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })

        db = Room.databaseBuilder(this, AppDatabase::class.java, "production").allowMainThreadQueries()
                .build()
    }

    private fun setSupportToActionBar() {
        setSupportActionBar(main_page_toolbar as Toolbar)
        supportActionBar?.title = "New task"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    fun saveTask(view: View) {

        // VIEWMODEL:
        val title = task_title.text.toString()
        val description = task_description.text.toString()
        val pomodoroAmount = 4
        val isCompleted = false

        db.taskDao().insertAll(Task(
                title,
                description,
                pomodoroAmount,
                isCompleted
        ))

        val mainActivityIntent = Intent(this@NewTaskActivity, MainActivity::class.java)
        mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(mainActivityIntent)
        this.finish()

    }
}
