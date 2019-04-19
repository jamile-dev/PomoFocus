package io.github.jamilelima.pomofocus.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import io.github.jamilelima.pomofocus.R
import io.github.jamilelima.pomofocus.Adapters.TabsAssessorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_page_toolbar as Toolbar)
        supportActionBar?.title = "Tasks"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        main_tabs_pager?.adapter = TabsAssessorAdapter(supportFragmentManager)
        main_tabs?.setupWithViewPager(main_tabs_pager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == R.id.how_it_works_options) {

        }

        if (item.itemId == R.id.settings_options) {
            this.sendUserToSettingsActivity()
        }
        return true
    }

    private fun sendUserToSettingsActivity() {
        val settingsActivity = Intent(this@MainActivity, SettingsActivity::class.java)
        startActivity(settingsActivity)
    }

    fun sendUserToNewTaskActivity(View: android.view.View) {
        val newTaskActivity = Intent(this@MainActivity, NewTaskActivity::class.java)
        startActivity(newTaskActivity)
    }
}
