package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculateBMI,clear;
        EditText edtxtWeightKg,edtxtHeightFt,edtHeightInch;
        TextView result;
        calculateBMI=findViewById(R.id.calculateBMI);
        clear=findViewById(R.id.clear);
        edtxtHeightFt=findViewById(R.id.edtxtHeightFt);
        edtHeightInch=findViewById(R.id.edtxtHeightInch);
        edtxtWeightKg=findViewById(R.id.edtxtWeightKg);
        result=findViewById(R.id.result);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtxtHeightFt.setText("");
                edtHeightInch.setText("");
                edtxtWeightKg.setText("");
                result.setText("");
                result.setBackgroundColor(getResources().getColor(R.color.white));
            }
        });
        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heightFt=Integer.parseInt(edtxtHeightFt.getText().toString());
                int heightInch=Integer.parseInt(edtHeightInch.getText().toString());
                int weightKg=Integer.parseInt(edtxtWeightKg.getText().toString());
                heightInch=heightFt*12+heightInch;
                double heightM=(heightInch*2.53)/100;
                double BMI=weightKg/(heightM*heightM);
                if(BMI>25){
                    result.setText(getResources().getString(R.string.overweight));
                    result.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (BMI<18) {
                    result.setText(getResources().getString(R.string.underweight));
                    result.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    result.setBackgroundColor(getResources().getColor(R.color.green));
                    result.setText(getResources().getString(R.string.healty));
                }
            }
        });


    }
}