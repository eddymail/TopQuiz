package edouard.lousssouarn.com.topquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

   private TextView gQuestionText;
   private Button gAnswer1Button;
   private Button gAnswer2Button;
   private Button gAnswer3Button;
   private Button gAnswer4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        gAnswer1Button = (Button) findViewById(R.id.activity_game_answer1_btn);
        gAnswer2Button = (Button) findViewById(R.id.activity_game_answer2_btn);
        gAnswer3Button = (Button) findViewById(R.id.activity_game_answer3_btn);
        gAnswer4Button = (Button) findViewById(R.id.activity_game_answer4_btn);
    }
}
