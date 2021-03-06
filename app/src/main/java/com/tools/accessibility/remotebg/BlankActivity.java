package com.tools.accessibility.remotebg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiang.batterytest.R;

public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        boolean vIsFinish = getIntent().getBooleanExtra("finish", false);
        if(vIsFinish){
            PhoneType.getInstance().sendOver();
            finish();
        }
        else{
            PhoneType.getInstance().realStart(this);
        }
    }
}
