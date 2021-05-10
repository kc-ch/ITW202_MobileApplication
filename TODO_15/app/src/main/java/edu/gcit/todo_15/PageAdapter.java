package edu.gcit.todo_15;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int mNullOfTabs;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mNullOfTabs = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TabFragment1();
            case 1: return new TabFragment2();
            case 2: return new TabFragment3();
            default: return null;
        }

    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mNullOfTabs;
    }
}
