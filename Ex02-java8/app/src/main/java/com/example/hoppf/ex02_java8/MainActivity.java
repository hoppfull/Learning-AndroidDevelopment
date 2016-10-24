package com.example.hoppf.ex02_java8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        TextView txv_mytextview = (TextView) findViewById(R.id.txv_mytextview);
        Button btn_mybutton1 = (Button) findViewById(R.id.btn_mybutton1);
        Button btn_mybutton2 = (Button) findViewById(R.id.btn_mybutton2);

        // Old way:
        btn_mybutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txv_mytextview.setText(R.string.txv_mytextview_state_btn1);
            }
        });

        // New way:
        btn_mybutton2.setOnClickListener(view -> {
            txv_mytextview.setText(R.string.txv_mytextview_state_btn2);
        });
    }
}
