package io.github.jamilelima.pomofocus.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import io.github.jamilelima.pomofocus.Fragments.TasksDoneFragment;
import io.github.jamilelima.pomofocus.Fragments.TasksPendingFragment;

public class TabsAssessorAdapter extends FragmentPagerAdapter {


    public TabsAssessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                TasksPendingFragment tasksPendingFragment = new TasksPendingFragment();
                return tasksPendingFragment;
            case 1:
                TasksDoneFragment tasksDoneFragment = new TasksDoneFragment();
                return tasksDoneFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Pending";

            case 1:
                return "Done";

            default:
                return null;
        }
    }
}
