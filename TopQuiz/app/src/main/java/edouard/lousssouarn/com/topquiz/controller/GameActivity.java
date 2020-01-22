package edouard.lousssouarn.com.topquiz.controller;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import edouard.lousssouarn.com.topquiz.R;
import edouard.lousssouarn.com.topquiz.model.Question;
import edouard.lousssouarn.com.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

   private TextView mQuestionTextView;
   private Button mAnswer1Button;
   private Button mAnswer2Button;
   private Button mAnswer3Button;
   private Button mAnswer4Button;

   private QuestionBank mQuestionBank;
   private Question mCurrentQuestion;

   private int mScore;
   private int mNumberOfQuestions;

   public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
   public static final String BUNDLE_STATE_SCORE = "currentScore";
   public static final String BUNDLE_STATE_QUESTION = "currentQuestion";

   private boolean mEnableTouchEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate");

        mQuestionBank = this.generateQuestions();

        if(savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 6;
        }

        mEnableTouchEvents = true;

        //Branchement des Widgets
        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswer1Button = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswer2Button= (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswer3Button = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswer4Button = (Button) findViewById(R.id.activity_game_answer4_btn);

        //Use the tag property to 'name' the buttons
        mAnswer1Button.setTag(0);
        mAnswer2Button.setTag(1);
        mAnswer3Button.setTag(2);
        mAnswer4Button.setTag(3);

        mAnswer1Button.setOnClickListener(this);
        mAnswer2Button.setOnClickListener(this);
        mAnswer3Button.setOnClickListener(this);
        mAnswer4Button.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            //good answer
            Toast.makeText(this, "Bonne réponse", Toast.LENGTH_SHORT).show();
            mScore++;
        }else{
            //wrong answer
            Toast.makeText(this, "Eh non, mauvaise réponse !", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                // If this is the last question, ends the game.
                // Else, display the next question.
                if (--mNumberOfQuestions == 0) {
                    // End the game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000); // LENGTH_SHORT is usually 2 second long
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Bien joué!")
                .setMessage("Ton score est de  " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //End the activity
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }

    private void displayQuestion(final Question question){
        mQuestionTextView.setText(question.getQuestion());
        mAnswer1Button.setText(question.getChoiceList().get(0));
        mAnswer2Button.setText(question.getChoiceList().get(1));
        mAnswer3Button.setText(question.getChoiceList().get(2));
        mAnswer4Button.setText(question.getChoiceList().get(3));

    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Combien de film Star Wars existent-ils?",
                Arrays.asList("11", "6", "9", "3"),
                0);

        Question question4 = new Question("De quelle couleur est le sabre de maître Yoda?",
                Arrays.asList("il n'a pas de sabre", "rouge", "bleu", "vert"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("GameActivity::onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("GameActivity::onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("GameActivity::onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("GameActivity::onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("GameActivity::onResume");
    }
}
