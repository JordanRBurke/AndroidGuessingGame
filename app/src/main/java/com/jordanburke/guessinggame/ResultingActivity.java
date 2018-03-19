package com.jordanburke.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultingActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumberTextview;
    private TextView resultingView;
    private ImageView resultImageView;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulting);

        playAgainButton = findViewById(R.id.play_again_button);
        correctNumberTextview = findViewById(R.id.generated_number_view);
        resultingView = findViewById(R.id.generated_textview);
        resultImageView = findViewById(R.id.result_photo);

        buttonPress();
        intent = getIntent();
        if(intent.hasExtra("WINNING_NUMBER")) {
            setLosingData();
        }
    }


    private void setLosingData() {
        int winningNumber = intent.getIntExtra("WINNING_NUMBER", 0);
                resultingView.setText(R.string.you_lost);
        correctNumberTextview.setText(getString(R.string.winning_number, winningNumber));
        resultImageView.setImageResource(R.drawable.sad_face_photo);


    }

    private void buttonPress() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
