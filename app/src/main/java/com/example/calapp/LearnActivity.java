package com.example.calapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class LearnActivity extends AppCompatActivity {
    private int cnt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_main);

        final Intent mainIntent = new Intent(this, MainActivity.class);
        final TextView txtWord1 = findViewById(R.id.txtWord1);
        final TextView txtWord2 = findViewById(R.id.txtWord2);
        final TextView txtWord3 = findViewById(R.id.txtWord3);
        final Button btnNext = findViewById(R.id.btnNext);
        final Button btnAns = findViewById(R.id.btnAns);
        final Button btnInit = findViewById(R.id.btnInit);

        Intent intent = getIntent();

        Random ran = new Random();

        int num1 = ran.nextInt(300) + 100;
        int num2 = ran.nextInt(299) + 1;
        int sign = ran.nextInt(2);

        txtWord1.setText(""+num1);
        if(sign==0){
            txtWord2.setText("+");
        }else{
            txtWord2.setText("-");
        }
        txtWord3.setText(""+num2);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (cnt < 5) {
                    cnt++;
                    Random ran = new Random();

                    int num1 = ran.nextInt(300) + 100;
                    int num2 = ran.nextInt(299) + 1;
                    int sign = ran.nextInt(2);

                    txtWord1.setText(""+num1);
                    if(sign==0){
                        txtWord2.setText("+");
                    }else{
                        txtWord2.setText("-");
                    }
                    txtWord3.setText(""+num2);


                } else {
                    Toast.makeText(LearnActivity.this, "마지막 문제입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(mainIntent);
                finish();
            }
        });

    }

}
