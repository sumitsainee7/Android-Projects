package com.example.ticktacktoegame;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn11,btn12,btn13,btn21,btn22,btn23,btn31,btn32,btn33,clear;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }
    public void check(View view){
        Button btn= (Button) view;
        String b11,b12,b13,b21,b22,b23,b31,b32,b33;
        String result;
        if(btn.getText().equals("")) {
            if (count % 2 == 0) {
                count++;
                btn.setText(getResources().getString(R.string.zero));
            } else {
                count++;
                btn.setText(getResources().getString(R.string.cross));
            }
            if(count>4){
                b11=btn11.getText().toString();
                b12=btn12.getText().toString();
                b13=btn13.getText().toString();
                b21=btn21.getText().toString();
                b22=btn22.getText().toString();
                b23=btn23.getText().toString();
                b31=btn31.getText().toString();
                b32=btn32.getText().toString();
                b33=btn33.getText().toString();
                if(b11.equals(b12) && b11.equals(b13) && !b11.equals("")
                    || b11.equals(b21) && b11.equals(b31) && !b11.equals("")
                        || b11.equals(b22) && b11.equals(b33) && !b11.equals("")
                        || b12.equals(b22) && b12.equals(b32) && !b12.equals("")
                        || b13.equals(b23) && b13.equals(b33) && !b13.equals("")
                        || b31.equals(b22) && b31.equals(b13) && !b31.equals("")
                        || b21.equals(b22) && b21.equals(b23) && !b21.equals("")
                        || b31.equals(b32) && b31.equals(b33) && !b31.equals("")){
                    Toast toast= Toast.makeText(this,"Winner is"+btn.getText().toString(),Toast.LENGTH_LONG);
                    toast.show();
                    clear();
                }
                else if(count==9){
                    Toast toast= Toast.makeText(this,"Match is Draw",Toast.LENGTH_LONG);
                    toast.show();
                    clear();
                }
            }
        }
    }
    void init(){
        btn11=findViewById(R.id.btn11);
        btn12=findViewById(R.id.btn12);
        btn13=findViewById(R.id.btn13);
        btn21=findViewById(R.id.btn21);
        btn22=findViewById(R.id.btn22);
        btn23=findViewById(R.id.btn23);
        btn31=findViewById(R.id.btn31);
        btn32=findViewById(R.id.btn32);
        btn33=findViewById(R.id.btn33);
        clear=findViewById(R.id.clear);
    }
    void clear(){
        btn11.setText("");
        btn12.setText("");
        btn13.setText("");
        btn21.setText("");
        btn22.setText("");
        btn23.setText("");
        btn31.setText("");
        btn32.setText("");
        btn33.setText("");
        count=0;
    }


}