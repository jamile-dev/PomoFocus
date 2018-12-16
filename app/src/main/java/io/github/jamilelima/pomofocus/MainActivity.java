package io.github.jamilelima.pomofocus;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private ViewPager myViewPager;
    private TabLayout myTabLayout;
    private TabsAssessorAdapter myTabsAssessorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Tasks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        myViewPager = findViewById(R.id.main_tabs_pager);

        myTabsAssessorAdapter = new TabsAssessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAssessorAdapter);

        myTabLayout = findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.how_it_works_options) {

        }

        if(item.getItemId() == R.id.settings_options) {
            this.sendUserToSettingsActivity();
        }
        return true;
    }

    private void sendUserToSettingsActivity() {
        Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(settingsActivity);
    }

    public void sendUserToNewTaskActivity(android.view.View View) {
        Intent newTaskActivity = new Intent(MainActivity.this, NewTaskActivity.class);
        startActivity(newTaskActivity);
    }
}
