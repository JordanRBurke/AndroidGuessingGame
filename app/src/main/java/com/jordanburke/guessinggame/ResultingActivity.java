package com.jordanburke.guessinggame;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulting);

        playAgainButton = findViewById(R.id.play_again_button);
        correctNumberTextview = findViewById(R.id.generated_number_view);
        resultingView = findViewById(R.id.generated_textview);
//        resultImageView = findViewById(R.id.)
        buttonPress();
    }

    private void buttonPress() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
