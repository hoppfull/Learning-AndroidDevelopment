package com.example.hoppf.ex05_completablefuture;
// https://developer.android.com/reference/java/util/concurrent/CompletableFuture.html

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java8.util.concurrent.CompletableFuture;

public class MainActivity extends AppCompatActivity {
    ExecutorService pool = Executors.newFixedThreadPool(2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txv_mytextview = (TextView) findViewById(R.id.txv_mytextview);
        Button btn_mybutton = (Button) findViewById(R.id.btn_mybutton);

        CompletableFuture<Integer> cfuture = CompletableFuture
                .supplyAsync(() -> "hello", pool)
                .thenApply(s -> s.length());

        btn_mybutton.setOnClickListener(view -> {
            try {
                txv_mytextview.setText("async result: " + cfuture.get());
            } catch (Exception e) {
                txv_mytextview.setText("error with async operation!");
            }
        });
    }
}
