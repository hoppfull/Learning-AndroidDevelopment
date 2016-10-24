package com.example.hoppf.ex04_bundlesandparcelables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txv_activity_second_field1 =
                (TextView) findViewById(R.id.txv_activity_second_field1);
        TextView txv_activity_second_field2 =
                (TextView) findViewById(R.id.txv_activity_second_field2);

        Bundle state = getIntent().getExtras();
        MyModel myModel = state.getParcelable("mystate");

        txv_activity_second_field1.setText("s: " + myModel.s);
        txv_activity_second_field2.setText("x: " + myModel.x);
    }
}
