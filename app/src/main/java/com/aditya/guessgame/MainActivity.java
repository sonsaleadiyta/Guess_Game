package com.aditya.guessgame;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
     private int random_number;
    private EditText range;
    private EditText guess;
    private Button resultButton;
    private TextView showTextView;
    private Button reset1;
    static  int chance = 3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset1=findViewById(R.id.reset1);
        range= findViewById(R.id.range);
        guess= findViewById(R.id.guess);
        resultButton = findViewById(R.id.result);
        showTextView = findViewById(R.id.show);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (range.getText().toString().isEmpty() || guess.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER RANGE AND GUESS CORRECTLY ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(chance==3) {
                        generate_rn();
                    }
                    fun();
                }
            }
        });
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    range.getText().clear();
                    guess.getText().clear();
                    chance=3;
                Toast.makeText(MainActivity.this, "INPUT RESETED", Toast.LENGTH_SHORT).show();
                showTextView.setText("         NOTE  :  You Have Three Chances");

            }
        });

    }

    public void fun()
    {
        if (chance == 1) {
            showTextView.setText("       BETTER LUCK NEXT TIME🥺🥺!!! ");
        } else if (range.getText().toString().isEmpty() || guess.getText().toString().isEmpty())  {
                Toast.makeText(this, "please enter range ", Toast.LENGTH_SHORT).show();
            } else {
                int user_guess = Integer.parseInt(guess.getText().toString());
                    //int user_guess = Integer.parseInt(guess.getText().toString());
                    if (random_number == user_guess) {
                        showTextView.setText("        🎉🎉 YOU WON THE GAME🎉🎉");
                        range.getText().clear();
                        guess.getText().clear();
                        return;
                    } else if (user_guess > random_number) {
                        guess.getText().clear();
                        showTextView.setText("         YOUR GUESS IS GREATER 😬😬");
                    } else {
                        guess.getText().clear();
                        showTextView.setText("         YOUR GUESS IS SMALLER 😟😟");
                }

                chance--;
                Toast.makeText(this, (chance+" attempts remaining "), Toast.LENGTH_SHORT).show();
            }

        }

    public void generate_rn() {
        try {
            int r = Integer.parseInt(range.getText().toString());
            Random random = new Random();
            random_number = random.nextInt(r + 1);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

