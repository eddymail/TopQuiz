package edouard.lousssouarn.com.topquiz.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        //Mélangez la liste de questions avant de la stocker
       Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        // Loop over the questions and return a new one at each call
        //Parcourez les questions et renvoyez-en une nouvelle à chaque appel
    if (mNextQuestionIndex == mQuestionList.size()){
        mNextQuestionIndex = 0;
    }
    //Please note the post-incrementation
    //Veuillez noter la post-incrémentation
        return mQuestionList.get(mNextQuestionIndex++);
    }
}
