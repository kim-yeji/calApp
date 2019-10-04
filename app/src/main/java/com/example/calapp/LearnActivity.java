package com.example.calapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        final TextView txtResult = findViewById(R.id.txtResult);
        final EditText txtAnswer = findViewById(R.id.txtAnswer);
        final Button btnNext = findViewById(R.id.btnNext);
        final Button btnAns = findViewById(R.id.btnAns);
        final Button btnInit = findViewById(R.id.btnInit);

        Intent intent = getIntent();

        cal(txtWord1,txtWord2,txtWord3);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (cnt < 5) {
                    cnt++;
                    int tmp = cal(txtWord1,txtWord2,txtWord3);
                    int tmp2 = Integer.parseInt(txtAnswer.getText().toString());
                    if(tmp==tmp2){
                        txtResult.setText("정답입니다.");
                    }else{
                        txtResult.setText("틀렸습니다.");
                    }


                } else {
                    Toast.makeText(LearnActivity.this, "마지막 문제입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAns.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

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

    public static int cal(TextView txtWord1,TextView txtWord2,TextView txtWord3){
        Random ran = new Random();

        int num1 = ran.nextInt(300) + 100;
        int num2 = ran.nextInt(199) + 1;
        int sign = ran.nextInt(2);

        txtWord1.setText(""+num1);
        if(sign==0){
            txtWord2.setText("+");
        }else{
            txtWord2.setText("-");
        }
        txtWord3.setText(""+num2);

        return num1+num2;
    }

}
