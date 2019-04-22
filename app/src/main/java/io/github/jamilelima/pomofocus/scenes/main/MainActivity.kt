package io.github.jamilelima.pomofocus.scenes.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.github.jamilelima.pomofocus.R
import io.github.jamilelima.pomofocus.scenes.newTask.NewTaskActivity
import io.github.jamilelima.pomofocus.activities.SettingsActivity
import io.github.jamilelima.pomofocus.adapters.TabsAssessorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Main.View {

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setActionBarSupport()
        this.setAdapterSupport()
    }

    private fun setActionBarSupport() {
        setSupportActionBar(main_page_toolbar as Toolbar)
        supportActionBar?.title = "Tasks"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun setAdapterSupport() {
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
        presenter.presentSelectedOption(item.itemId, R.id.how_it_works_options, R.id.settings_options)
        return true
    }

    override fun displaySettingsActivity() {
        val settingsActivity = Intent(this@MainActivity, SettingsActivity::class.java)
        startActivity(settingsActivity)
    }

    fun displayNewTaskActivity(view: View) {
        val newTaskActivity = Intent(this@MainActivity, NewTaskActivity::class.java)
        startActivity(newTaskActivity)
    }

    override fun displayHowItWorksActivity() {
       // @TODO: IMPLEMENTS THIS OKAY?
    }
}
