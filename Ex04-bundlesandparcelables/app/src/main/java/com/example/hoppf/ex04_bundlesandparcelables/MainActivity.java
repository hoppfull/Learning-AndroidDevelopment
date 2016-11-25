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
            MyModelA myModelA = new MyModelA(new MyModelB(7), new MyModelC[] {
                    new MyModelC("huey"),
                    new MyModelC("dewey"),
                    new MyModelC("louie")
            });
            MyModelB myModelB = new MyModelB(42);
            MyModelC myModelC = new MyModelC("hello");

            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("myModelA", myModelA);
            intent.putExtra("myModelB", myModelB);
            intent.putExtra("myModelC", myModelC);

            startActivity(intent);
        });
    }
}
