package edouard.lousssouarn.com.topquiz.model;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import edouard.lousssouarn.com.topquiz.R;


public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MyViewHolder>{


    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mFirstnameTV;
        private TextView mScoreTV;

        MyViewHolder(View rankingView) {
            super(rankingView);

            mFirstnameTV = (TextView)rankingView.findViewById(R.id.name_txt);
            mScoreTV = (TextView)rankingView.findViewById(R.id.score_txt);

        }

        void display(User user){

            mFirstnameTV.setText(user.getFirstname());
            mScoreTV.setText(user.getScore() + "points");
        }

    }

    List<User> userRanking;

    public RankingAdapter(List<User> userRanking) {
        this.userRanking = userRanking;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.score_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(userRanking.get(position));
    }

    @Override
    public int getItemCount() {
        return Math.max(5,this.userRanking.size());
    }
}
