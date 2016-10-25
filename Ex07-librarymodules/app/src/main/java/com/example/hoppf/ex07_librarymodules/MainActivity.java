package com.example.hoppf.ex07_librarymodules;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.mylibrary.MyLibraryClass;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv_feedback = (TextView) findViewById(R.id.txv_feedback);
        txv_feedback.setText(MyLibraryClass.msg);
    }
}
