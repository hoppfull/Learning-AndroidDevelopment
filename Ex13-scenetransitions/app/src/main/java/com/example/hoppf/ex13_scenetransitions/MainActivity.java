package com.example.hoppf.ex13_scenetransitions;

import android.support.transition.TransitionManager;
import android.support.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Runnable onBack = () -> { };
    @Override
    public void onBackPressed() {
        onBack.run();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();

        ViewGroup frl_master = (ViewGroup) findViewById(R.id.frl_master);

        ViewGroup rll_container1 =
                (ViewGroup) inflater.inflate(R.layout.main_scene1, frl_master, false);

        ViewGroup rll_container2 =
                (ViewGroup) inflater.inflate(R.layout.main_scene2, frl_master, false);

        final Scene scene1 = new Scene(frl_master, rll_container1);
        final Scene scene2 = new Scene(frl_master, rll_container2);

        TransitionManager.go(scene1);

        // https://www.bignerdranch.com/blog/building-animations-android-transition-framework-part-1/
        Button btn_mybutton = (Button) findViewById(R.id.btn_mybutton);

        btn_mybutton.setOnClickListener(view -> TransitionManager.go(scene2));

        onBack = () -> TransitionManager.go(scene1);
    }
}
