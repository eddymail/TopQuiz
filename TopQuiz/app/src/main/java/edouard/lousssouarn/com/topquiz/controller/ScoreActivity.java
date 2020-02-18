package edouard.lousssouarn.com.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edouard.lousssouarn.com.topquiz.R;
import edouard.lousssouarn.com.topquiz.model.RankingAdapter;
import edouard.lousssouarn.com.topquiz.model.User;

import static edouard.lousssouarn.com.topquiz.controller.MainActivity.SCORE_ACTIVITY_REQUEST_CODE;


public class ScoreActivity extends AppCompatActivity {

    private Button mDecreasingScoreButton;
    private Button mAlphabeticalOrder;
    private String firstname;
    private int score;

    private RecyclerView mRecyclerView;
    private List<User>userRanking;
    private RankingAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mDecreasingScoreButton = (Button) findViewById(R.id.activity_score_order_number_btn);
        mAlphabeticalOrder = (Button) findViewById(R.id.activity_score_order_name_btn);

        mRecyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);

        userRanking = new ArrayList<>();

        userRanking.add(new User(firstname, score));

        myAdapter = new RankingAdapter(userRanking);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(myAdapter);
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
