package com.example.hoppf.ex06_handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv_feedback = (TextView) findViewById(R.id.txv_feedback);

        Handler handler = new Handler();

        txv_feedback.setText(R.string.str_loading);
        Thread t = new Thread(() -> {
            // Fake work:
            try { Thread.sleep(5000);
            } catch (Exception e) { }
            // This will fail:
            //txv_feedback.setText(R.string.str_done);
            // This will work:
            handler.post(() -> txv_feedback.setText(R.string.str_done));
        });
        t.start();
    }
}
