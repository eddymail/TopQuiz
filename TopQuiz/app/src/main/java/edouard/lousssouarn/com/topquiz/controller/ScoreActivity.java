package edouard.lousssouarn.com.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edouard.lousssouarn.com.topquiz.R;

import static edouard.lousssouarn.com.topquiz.controller.MainActivity.SCORE_ACTIVITY_REQUEST_CODE;


public class ScoreActivity extends AppCompatActivity {

    private Button mDecreasingScoreButton;
    private Button mAlphabeticalOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mDecreasingScoreButton = (Button) findViewById(R.id.activity_score_order_number_btn);
        mAlphabeticalOrder = (Button) findViewById(R.id.activity_score_order_name_btn);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (SCORE_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            int firstname = data.getIntExtra(MainActivity.BUNDLE_EXTRA_FIRSTNAME, 0);
        }
    }


}
