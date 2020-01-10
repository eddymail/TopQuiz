package edouard.lousssouarn.com.topquiz.model;

import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        // Shuffle the question list before storing it
        mQuestionList = questionList;

        mNextQuestionIndex = 0;
    }

    public Question getQuestion() {
        // Loop over the questions and return a new one at each call
    if (mNextQuestionIndex == mQuestionList.size()){
        mNextQuestionIndex = 0;
    }
    //Please note the post-incrementation
        return mQuestionList.get(mNextQuestionIndex++);
    }
}
