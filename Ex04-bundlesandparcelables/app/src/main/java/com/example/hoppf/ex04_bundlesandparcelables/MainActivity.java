package com.example.hoppf.ex04_bundlesandparcelables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_mybutton = (Button) findViewById(R.id.btn_mybutton);

        btn_mybutton.setOnClickListener(view -> {
            MyModel myModel = new MyModel("How many dwarves?", 7);
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("mystate", myModel);

            startActivity(intent);
        });
    }
}
