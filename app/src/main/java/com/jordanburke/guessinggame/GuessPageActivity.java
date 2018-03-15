package com.jordanburke.guessinggame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessPageActivity extends AppCompatActivity {
    private EditText guessText;
    private Button textSubmit;
    private TextView clueTextView;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_page);
        guessText = findViewById(R.id.input_text_box);
        textSubmit = findViewById(R.id.submit_button);
        clueTextView = findViewById(R.id.guess_clue_view);
        listenForButtonClick();



    }

    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);


    }

    private void listenForButtonClick() {
        textSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userGuess = Integer.parseInt(clueTextView.getText().toString());
                checkGuess(userGuess);
                int guess = Integer.parseInt(guessText.getText().toString());
                if (guess > 100) {
                    clueTextView.setText("Enter a valid number between 1 - 100!");
                    clueTextView.setVisibility(View.VISIBLE);
                    guessText.setText("");

                } else {
                    checkGuess(userGuess);
                }


                Toast.makeText(GuessPageActivity.this, String.valueOf(guess), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void checkGuess(int userGuess) {
        if (userGuess == generatedNumber) {
            // TODO - Create intent to go to winning activity
            System.out.println("You have guessed the correct number");
        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            // TODO - Create intent to go to winning activity - handle out of chances
            System.out.println("Sorry you have ran out of chances. The correct number was " + generatedNumber);
            numberOfGuesses++;
        } else if (userGuess < generatedNumber) {
           clueTextView.setText("Higher");
           clueTextView.setVisibility(View.VISIBLE);
           guessText.setText("");
            numberOfGuesses++;
        } else if (userGuess > generatedNumber) {
            System.out.println("Your number is too high");
            numberOfGuesses++;


        }

    }

}
