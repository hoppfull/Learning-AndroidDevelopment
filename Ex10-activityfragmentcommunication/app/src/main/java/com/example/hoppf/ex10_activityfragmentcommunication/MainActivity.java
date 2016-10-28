package com.example.hoppf.ex10_activityfragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv_main = (TextView) findViewById(R.id.txv_main);
        Button btn_main = (Button) findViewById(R.id.btn_main);
        FrameLayout frm_main = (FrameLayout) findViewById(R.id.frm_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        View myFragment = inflater.inflate(R.layout.fragment_my, null);
        TextView txv_myfragment = (TextView) myFragment.findViewById(R.id.txv_myfragment);
        Button btn_myfragment = (Button) myFragment.findViewById(R.id.btn_myfragment);

        btn_main.setOnClickListener(view ->
                txv_myfragment.setText("Hello from activity! i = " + (i++)));

        btn_myfragment.setOnClickListener(view ->
                txv_main.setText("Hello from fragment! i = " + (i++)));

        frm_main.addView(myFragment);
    }
}
