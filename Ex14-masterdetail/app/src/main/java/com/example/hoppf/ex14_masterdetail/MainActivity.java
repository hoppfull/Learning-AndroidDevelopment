package com.example.hoppf.ex14_masterdetail;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java8.util.function.Consumer;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private Consumer<Fragment> loadFragment = fragment -> { };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment = fragment -> getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.frl_maincontainer, fragment)
                .commit();

        loadMasterFragment();
    }

    @Override
    public void loadMasterFragment() {
        loadFragment.accept(new MasterFragment());
    }

    @Override
    public void loadDetailFragment(Bundle state) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(state);
        loadFragment.accept(detailFragment);
    }
}
