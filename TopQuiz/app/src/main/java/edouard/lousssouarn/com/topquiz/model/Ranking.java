package edouard.lousssouarn.com.topquiz.model;

import java.util.Map;

public class Ranking  {

    private Map<String,Integer> mUserScoreList;
    private int positionRanking;

    public Ranking(Map<String, Integer> userScoreList, int positionRanking) {
        mUserScoreList = userScoreList;
        this.positionRanking = positionRanking;
    }

    public Map<String, Integer> getUserScoreList() {
        return mUserScoreList;
    }

    public void setUserScoreList(Map<String, Integer> userScoreList) {
        mUserScoreList = userScoreList;
    }
}
