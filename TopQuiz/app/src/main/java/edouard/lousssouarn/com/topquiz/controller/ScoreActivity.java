package edouard.lousssouarn.com.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edouard.lousssouarn.com.topquiz.R;
import edouard.lousssouarn.com.topquiz.model.Ranking;


public class ScoreActivity extends AppCompatActivity {

    private Button mDecreasingScoreButton;
    private Button mAlphabeticalOrder;
    private TextView mFirstPlayer;
    private TextView mSecondPlayer;
    private TextView mThirdPlayer;
    private TextView mFourthPlayer;
    private TextView mFifthPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mDecreasingScoreButton = (Button) findViewById(R.id.activity_score_order_number_btn);
        mAlphabeticalOrder = (Button) findViewById(R.id.activity_score_order_name_btn);
        mFirstPlayer = (TextView) findViewById(R.id.activity_score_player1_text);
        mSecondPlayer = (TextView) findViewById(R.id.activity_score_player2_text);
        mThirdPlayer = (TextView) findViewById(R.id.activity_score_player3_text);
        mFourthPlayer = (TextView) findViewById(R.id.activity_score_player4_text);
        mFifthPlayer = (TextView) findViewById(R.id.activity_score_player5_text);


    }
}
