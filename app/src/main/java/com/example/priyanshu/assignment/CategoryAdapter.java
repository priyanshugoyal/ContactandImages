package com.example.priyanshu.assignment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
/**
 * Created by Priyanshu on 18-May-17.
 */

public class CategoryAdapter extends FragmentPagerAdapter{
    private Context mContext;


    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);

        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ContactFragment();
        }
         else {
            return new ImageFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Contacts";
        } else {
            return "Images";
        }
    }
}
