package edouard.lousssouarn.com.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edouard.lousssouarn.com.topquiz.R;
import edouard.lousssouarn.com.topquiz.model.User;

public class MainActivity extends AppCompatActivity {

   private TextView mGreetingText;
   private EditText mNameInput;
   private Button mPlayButton;
   private Button mScoreButton;
   private User mUser;

   public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
   private SharedPreferences mPreferences;

   public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
   public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity::onCreate");

        mUser = new User();

        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);
        mScoreButton = (Button) findViewById(R.id.activity_main_score_btn);

        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() !=0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mNameInput.getText().toString();
                mUser.setFirstname(firstname);


                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstname()).apply();

                // The user just clicked
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivityIntent,GAME_ACTIVITY_REQUEST_CODE );
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE,score).apply();

            greetUser();
        }
    }

    private void greetUser() {
        String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != firstname) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Content de te revoir, " + firstname
                    + "!\nTon dernier score est de " + score
                    + ", est-ce que tu feras mieux aujourd'hui?";
            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
            mPlayButton.setEnabled(true);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("MainActivity::onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("MainActivity::onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("MainActivity::onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("MainActivity::onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("MainActivity::onResume");
    }
}
