package com.moutamid.kids_arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton easy , medium , hard ;
    RadioButton add , sub , mul , div ;
    TextView limit;
    ImageView decrement , increment ;
    Button btn_start ;

    private int couter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easy = findViewById(R.id.check_easy);
        medium = findViewById(R.id.check_medium);
        hard = findViewById(R.id.check_hard);

        add = findViewById(R.id.check_add);
        sub = findViewById(R.id.check_sub);
        mul = findViewById(R.id.check_multiplication);
        div = findViewById(R.id.check_div);

        btn_start = findViewById(R.id.btn_start);

        limit = findViewById(R.id.limit);
        decrement = findViewById(R.id.decrement);
        increment = findViewById(R.id.increment);

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (couter >= 0 && couter <= 9){
                    couter = couter + 1 ;
                    String limit_text = Integer.toString(couter);
                    limit.setText(limit_text);
                }
                else {
                    if (couter >= 1 && couter <= 10){
                        String limit_text = Integer.toString(couter);
                        limit.setText(limit_text);
                    }
                    Toast.makeText(MainActivity.this, "Choose only from 1-10", Toast.LENGTH_SHORT).show();
                }
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (couter >= 2 && couter <= 10){
                    couter = couter - 1 ;
                    String limit_text = Integer.toString(couter);
                    limit.setText(limit_text);
                }
                else {
                    if (couter >= 1 && couter <= 10){
                        String limit_text = Integer.toString(couter);
                        limit.setText(limit_text);
                    }
                    Toast.makeText(MainActivity.this, "Choose only from 1-10", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (easy.isChecked()){
                    if (add.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Easy_Addition.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (sub.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Easy_sub.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (mul.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Easy_Mul.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (div.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Easy_Div.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Select Both Level and Operations", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                if (medium.isChecked()){
                    if (add.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Medium_Addition.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (sub.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Medium_sub.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (mul.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Medium_Mul.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (div.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Medium_Div.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Select Both Level and Operations", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                if (hard.isChecked()){
                    if (add.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Hard_Addition.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (sub.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Hard_sub.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (mul.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Hard_Mul.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else if (div.isChecked()){
                        Intent intent = new Intent(MainActivity.this , Hard_Div.class);
                        String counter = Integer.toString(couter);
                        intent.putExtra("counters" , counter);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Select Both Level and Operations", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Select Both Level and Operations", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}