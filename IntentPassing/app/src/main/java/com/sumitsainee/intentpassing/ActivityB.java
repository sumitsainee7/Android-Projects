package com.sumitsainee.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Intent lastIntent=getIntent();
        String dataFromActivityA=lastIntent.getStringExtra("data");
        TextView TV_dataFromActivityA=findViewById(R.id.TV_dataFromActivityA);
        TV_dataFromActivityA.setText(dataFromActivityA);
        Intent intent= new Intent(ActivityB.this,MainActivity.class);
        Button activityA= (Button) findViewById(R.id.activityA);
        activityA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}