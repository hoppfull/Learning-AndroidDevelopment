package com.example.hoppf.ex11_bottomnavigationbar;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java8.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv_mybar = (BottomNavigationView) findViewById(R.id.bnv_mybar);

        FragmentManager fm = getSupportFragmentManager();

        Consumer<Fragment> loadFragment = fragment ->
            fm.beginTransaction().addToBackStack(null).replace(R.id.frl_myframe, fragment).commit();

        fm.beginTransaction().replace(R.id.frl_myframe, new HomeFragment()).commit();

        bnv_mybar.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bnv_mybar_home:
                    loadFragment.accept(new HomeFragment());
                    break;
                case R.id.bnv_mybar_contact:
                    loadFragment.accept(new ContactFragment());
                    break;
                case R.id.bnv_mybar_about:
                    loadFragment.accept(new AboutFragment());
                    break;
            }
            return false;
        });
    }
}
