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

public class Easy_Div extends AppCompatActivity {
    TextView num12 , num22 , result2 ;
    EditText answer2;
    Button btn_next2;
    TextView counter2 , counter_text2 ;

    private int couter2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_div);

        num12 = findViewById(R.id.num12);
        num22 = findViewById(R.id.num22);
        result2 = findViewById(R.id.result2);
        answer2 = findViewById(R.id.answer2);
        btn_next2 = findViewById(R.id.btn_next2);
        counter2 = findViewById(R.id.counter2);
        counter_text2 = findViewById(R.id.counter_text2);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            counter_text2.setText(bundle.getString("counters"));
        }

        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String my_ans = answer2.getText().toString().trim();
                if (my_ans.isEmpty()){
                    Toast.makeText(Easy_Div.this, "Enter Your Answer Here...", Toast.LENGTH_SHORT).show();
                }
                else {
                    String counter_text_limit = counter_text2.getText().toString().trim();
                    final int cnt = Integer.parseInt(counter_text_limit);
                    if (couter2 == cnt){
                        Intent intent = new Intent(Easy_Div.this , MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Easy_Div.this, "Successfully Finished...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    checkResult();
                }
            }
        });
    }

    private void checkResult() {
        String my_ans = answer2.getText().toString().trim();
        String my_result = result2.getText().toString().trim();
        if (my_ans.equals(my_result)){
            Toast.makeText(Easy_Div.this, "Answer is Right !", Toast.LENGTH_SHORT).show();
            changeQuestion();
            increment_counter();
        }
        else {
            Toast.makeText(Easy_Div.this, "Answer is Wrong !", Toast.LENGTH_SHORT).show();
        }
    }

    private void increment_counter() {
        String counter_text_limit = counter_text2.getText().toString().trim();
        final int cnt = Integer.parseInt(counter_text_limit);

        if (couter2 >= 0 && couter2 <= cnt){
            couter2 = couter2 + 1 ;
            String limit_text = Integer.toString(couter2);
            counter2.setText("Question # "+ limit_text);
        }
        else {
            if (couter2 >= 1 && couter2 <= cnt+1){
                String limit_text = Integer.toString(couter2);
                counter2.setText(limit_text);
            }
        }
    }

    private void changeQuestion() {
        final int min1 = 0;
        final int max1 = 10;
        final int random1 = new Random().nextInt((max1 - min1) + 1) + min1;
        String ran1 = Integer.toString(random1);

        final int min2 = 0;
        final int max2 = 10;
        final int random2 = new Random().nextInt((max2 - min2) + 1) + min2;
        String ran2 = Integer.toString(random2);


        final int total = random1 / random2 ;
        String tot = Integer.toString(total);

        num12.setText(ran1);
        num22.setText(ran2);
        result2.setText(tot);
        answer2.setText("");
    }

    @Override
    protected void onStart() {
        changeQuestion();
        super.onStart();
    }
}