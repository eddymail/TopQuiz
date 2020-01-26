package edouard.lousssouarn.com.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edouard.lousssouarn.com.topquiz.R;
import edouard.lousssouarn.com.topquiz.model.Ranking;

import static edouard.lousssouarn.com.topquiz.controller.MainActivity.PREF_KEY_FIRSTNAME;
import static edouard.lousssouarn.com.topquiz.controller.MainActivity.PREF_KEY_SCORE;

public class ScoreActivity extends AppCompatActivity {

    private Button mDecreasingScoreButton;
    private Button mAlphabeticalOrder;
    private TextView mFirstPlayer;
    private TextView mSecondPlayer;
    private TextView mThirdPlayer;
    private TextView mFourthPlayer;
    private TextView mFifthPlayer;

   /*private SharedPreferences mPreferences;

   String userName = mPreferences.getString(PREF_KEY_FIRSTNAME, null);
   int userScore = mPreferences.getInt(PREF_KEY_SCORE, 0);
   */
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

        /*mFirstPlayer.setTag(0);
        mSecondPlayer.setTag(1);
        mThirdPlayer.setTag(2);
        mFourthPlayer.setTag(3);
        mFifthPlayer.setTag(4);

         */
    }

   /* private Ranking generateRanking () {

        Ranking firstInTheRanking = new Ranking(Maps.asMap(userName,userScore),0);
        je cherche un equivalant à Arrays.asList pour passer le nom et le score sauvegarder comme paramètre ?
        j'ai aussi essayé ça:
        Ranking firstInTheRanking = new Ranking(userScoreList.getUserScoreList().put(userName , userScore));

        Ranking secondInTheRanking = new Ranking(Maps.asMap(userName,userScore),1);

        Ranking thirdInTheRanking = new Ranking(Maps.asMap(userName,userScore),2);

        Ranking fourthInTheRanking = new Ranking(Maps.asMap(userName,userScore),3);

        Ranking fifthInTheRanking = new Ranking(Maps.asMap(userName,userScore)4);

        return new generateRanking(Maps.asList(firstInTheRanking,
                secondInTheRanking,
                thirdInTheRanking,
                fourthInTheRanking,
                fifthInTheRanking,
                question6,
                question7,
                question8));
    }
    }

    private void displayRanking (final Ranking ranking){

        mFirstPlayer.setText (ranking.getUserScoreList().get(0));
        mSecondPlayer.setText (ranking.getUserScoreList().get(1));
        mThirdPlayer.setText(ranking.getUserScoreList().get(2));
        mFourthPlayer.setText(ranking.getUserScoreList().get(3));
        mFifthPlayer.setText(ranking.getUserScoreList().get(4));

    }
*/


}
