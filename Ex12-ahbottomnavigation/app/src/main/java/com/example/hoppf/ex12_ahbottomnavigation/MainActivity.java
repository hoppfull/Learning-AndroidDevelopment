package com.example.hoppf.ex12_ahbottomnavigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AHBottomNavigation ahb_navbar = (AHBottomNavigation) findViewById(R.id.ahb_navbar);

        AHBottomNavigationItem ahb_navbar_home = new AHBottomNavigationItem(
                getResources().getString(R.string.ahb_navbar_home),
                R.drawable.ic_nav_home);

        AHBottomNavigationItem ahb_navbar_search = new AHBottomNavigationItem(
                getResources().getString(R.string.ahb_navbar_search),
                R.drawable.ic_nav_search);

        AHBottomNavigationItem ahb_navbar_profile = new AHBottomNavigationItem(
                getResources().getString(R.string.ahb_navbar_profile),
                R.drawable.ic_nav_profile);

        ahb_navbar.addItem(ahb_navbar_home);
        ahb_navbar.addItem(ahb_navbar_search);
        ahb_navbar.addItem(ahb_navbar_profile);
    }
}
