package com.moutamid.kids_arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Hard_Mul extends AppCompatActivity {

    TextView num1 , num2 , result ;
    EditText answer;
    Button btn_next;
    TextView counter , counter_text ;

    private int couter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_mul);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        answer = findViewById(R.id.answer);
        btn_next = findViewById(R.id.btn_next);
        counter = findViewById(R.id.counter);
        counter_text = findViewById(R.id.counter_text);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            counter_text.setText(bundle.getString("counters"));
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String my_ans = answer.getText().toString().trim();
                if (my_ans.isEmpty()){
                    Toast.makeText(Hard_Mul.this, "Enter Your Answer Here...", Toast.LENGTH_SHORT).show();
                }
                else {
                    String counter_text_limit = counter_text.getText().toString().trim();
                    final int cnt = Integer.parseInt(counter_text_limit);
                    if (couter == cnt){
                        Intent intent = new Intent(Hard_Mul.this , MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Hard_Mul.this, "Successfully Finished...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    checkResult();
                }
            }
        });
    }

    private void checkResult() {
        String my_ans = answer.getText().toString().trim();
        String my_result = result.getText().toString().trim();
        if (my_ans.equals(my_result)){
            Toast.makeText(Hard_Mul.this, "Answer is Right !", Toast.LENGTH_SHORT).show();
            changeQuestion();
            increment_counter();
        }
        else {
            Toast.makeText(Hard_Mul.this, "Answer is Wrong !", Toast.LENGTH_SHORT).show();
        }
    }

    private void increment_counter() {
        String counter_text_limit = counter_text.getText().toString().trim();
        final int cnt = Integer.parseInt(counter_text_limit);

        if (couter >= 0 && couter <= cnt){
            couter = couter + 1 ;
            String limit_text = Integer.toString(couter);
            counter.setText("Question # "+ limit_text);
        }
        else {
            if (couter >= 1 && couter <= cnt+1){
                String limit_text = Integer.toString(couter);
                counter.setText(limit_text);
            }
        }
    }

    private void changeQuestion() {
        final int min1 = 0;
        final int max1 = 50;
        final int random1 = new Random().nextInt((max1 - min1) + 1) + min1;
        String ran1 = Integer.toString(random1);

        final int min2 = 0;
        final int max2 = 50;
        final int random2 = new Random().nextInt((max2 - min2) + 1) + min2;
        String ran2 = Integer.toString(random2);


        final int total = random1 * random2 ;
        String tot = Integer.toString(total);

        num1.setText(ran1);
        num2.setText(ran2);
        result.setText(tot);
        answer.setText("");
    }

    @Override
    protected void onStart() {
        changeQuestion();
        super.onStart();
    }
}