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
        TextView txv_activity_second_field3 =
                (TextView) findViewById(R.id.txv_activity_second_field3);
        TextView txv_activity_second_field4 =
                (TextView) findViewById(R.id.txv_activity_second_field4);
        TextView txv_activity_second_field5 =
                (TextView) findViewById(R.id.txv_activity_second_field5);
        TextView txv_activity_second_field6 =
                (TextView) findViewById(R.id.txv_activity_second_field6);
        TextView txv_activity_second_field7 =
                (TextView) findViewById(R.id.txv_activity_second_field7);

        Bundle extras = getIntent().getExtras();
        MyModelA myModelA = extras.getParcelable("myModelA");
        MyModelB myModelB = extras.getParcelable("myModelB");
        MyModelC myModelC = extras.getParcelable("myModelC");

        txv_activity_second_field1.setText("myModelA.myModelB.myFieldB = " + myModelA.myModelB.myFieldB);
        txv_activity_second_field2.setText("myModelA.myModelCs.length = " + myModelA.myModelCs.length);
        txv_activity_second_field3.setText("myModelA.myModelCs[0].myFieldC = " + myModelA.myModelCs[0].myFieldC);
        txv_activity_second_field4.setText("myModelA.myModelCs[1].myFieldC = " + myModelA.myModelCs[1].myFieldC);
        txv_activity_second_field5.setText("myModelA.myModelCs[2].myFieldC = " + myModelA.myModelCs[2].myFieldC);
        txv_activity_second_field6.setText("myModelB.myFieldB = " + myModelB.myFieldB);
        txv_activity_second_field7.setText("myModelC.myFieldC = " + myModelC.myFieldC);
    }
}
