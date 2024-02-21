package com.sumitsainee.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText=findViewById(R.id.editTextA);
        Intent intent= new Intent(MainActivity.this,ActivityB.class);
        Button activityB= (Button) findViewById(R.id.activityB);
        activityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("data",editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}