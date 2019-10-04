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

        // 초기값
        setNum(txtWord1, txtWord2, txtWord3);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (cnt < 5) {
                    setNum(txtWord1, txtWord2, txtWord3);
                    cnt++;
                } else {
                    Toast.makeText(LearnActivity.this, "마지막 문제입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(txtAnswer.getText() == null || "".equals(txtAnswer.getText().toString())){
                    Toast.makeText(LearnActivity.this, "답을 입력하세요.", Toast.LENGTH_SHORT).show();
                }else {
                    // 내가 쓴 답
                    int answer = Integer.parseInt(txtAnswer.getText().toString());
                    // 결과값
                    int result = cal(txtWord1.getText().toString(), txtWord3.getText().toString(), txtWord2.getText().toString());

                    if (answer == result) {
                        txtResult.setText("정답입니다.");
                    } else {
                        txtResult.setText("틀렸습니다.");
                    }
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

    // 숫자 셋팅
    public static void setNum(TextView txtWord1,TextView txtWord2,TextView txtWord3){
        Random ran = new Random();

        int num1 = ran.nextInt(20) + 10;
        int num2 = ran.nextInt(9) + 1;
        int sign = ran.nextInt(2);

        txtWord1.setText(""+num1);
        if(sign==0){
            txtWord2.setText("+");
        }else{
            txtWord2.setText("-");
        }
        txtWord3.setText(""+num2);
    }

    // 숫자 계산
    public static int cal(String num1, String num2, String op){
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        if("+".equals(op)){
            return a + b;
        }else{
            return a - b;
        }
    }

}
