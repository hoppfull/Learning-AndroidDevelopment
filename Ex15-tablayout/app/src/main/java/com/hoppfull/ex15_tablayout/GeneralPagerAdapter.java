package com.hoppfull.ex15_tablayout;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class GeneralPagerAdapter extends PagerAdapter {
    public final TitlePagePair[] titlePagePairs;
    public GeneralPagerAdapter(TitlePagePair[] titlePagePairs) {
        this.titlePagePairs = titlePagePairs;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        collection.addView(titlePagePairs[position].page);
        return titlePagePairs[position].page;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return titlePagePairs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlePagePairs[position].title;
    }

    public static class TitlePagePair {
        public final String title;
        public final ViewGroup page;
        public TitlePagePair(String title, ViewGroup page) {
            this.title = title;
            this.page = page;
        }
    }
}
