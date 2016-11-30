package com.hoppfull.ex15_tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tbl_tabs = (TabLayout) findViewById(R.id.tbl_tabs);
        ViewPager vpg_pages = (ViewPager) findViewById(R.id.vpg_pages);

        LayoutInflater inflater = LayoutInflater.from(this);

        ViewGroup page_red =
                (ViewGroup) inflater.inflate(R.layout.page_red, vpg_pages, false);
        ViewGroup page_green =
                (ViewGroup) inflater.inflate(R.layout.page_green, vpg_pages, false);
        ViewGroup page_blue =
                (ViewGroup) inflater.inflate(R.layout.page_blue, vpg_pages, false);

        GeneralPagerAdapter.TitlePagePair[] titlePagePairs =
                new GeneralPagerAdapter.TitlePagePair[] {
                        new GeneralPagerAdapter.TitlePagePair("Red", page_red),
                        new GeneralPagerAdapter.TitlePagePair("Green", page_green),
                        new GeneralPagerAdapter.TitlePagePair("Blue", page_blue) };

        vpg_pages.setAdapter(new GeneralPagerAdapter(titlePagePairs));

        tbl_tabs.setupWithViewPager(vpg_pages);
    }
}
