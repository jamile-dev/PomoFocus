package io.github.jamilelima.pomofocus.Activities

import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import io.github.jamilelima.pomofocus.R
import io.github.jamilelima.pomofocus.Adapters.TabsAssessorAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var mToolbar: Toolbar
    private lateinit var myViewPager: ViewPager
    private lateinit var myTabLayout: TabLayout
    private lateinit var myTabsAssessorAdapter: TabsAssessorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.main_page_toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.title = "Tasks"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)

        myViewPager = findViewById(R.id.main_tabs_pager)

        myTabsAssessorAdapter = TabsAssessorAdapter(supportFragmentManager)
        myViewPager?.adapter = myTabsAssessorAdapter

        myTabLayout = findViewById(R.id.main_tabs)
        myTabLayout?.setupWithViewPager(myViewPager)
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
