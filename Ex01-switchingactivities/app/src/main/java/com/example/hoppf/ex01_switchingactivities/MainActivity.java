package com.example.hoppf.ex01_switchingactivities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final Activity this_ = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Button btn_switchactivity = (Button) findViewById(R.id.btn_switchactivity);
        btn_switchactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this_, SecondActivity.class);
                intent.putExtra("myKey", "myValue");
                startActivity(intent);
            }
        });
    }
}
