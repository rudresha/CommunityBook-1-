package communitybook.android.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> implements View.OnClickListener {

    private List<Movie> moviesList;
    Context mContext;
    Activity mActiivty;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_like:
                
                break;
            case R.id.txt_comment:
                CommentsDialogFragment commentsDialogFragment = new CommentsDialogFragment();
                commentsDialogFragment.show(mActiivty.getFragmentManager(), "dialog");

                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView timeline_profile_name, title, year, genre, txtLike, txtComment;
        public MyViewHolder(View view) {
            super(view);
            timeline_profile_name = (TextView) view.findViewById(R.id.timeline_profile_name);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            txtLike = (TextView) view.findViewById(R.id.txt_like);
            txtComment = (TextView) view.findViewById(R.id.txt_comment);
        }
    }


    public MoviesAdapter(List<Movie> moviesList, Activity activity) {
        this.moviesList = moviesList;
        mActiivty = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.timeline_profile_name.setText(movie.getTimeline_profile_name());
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());

        holder.txtComment.setOnClickListener(this);
        holder.txtLike.setOnClickListener(this);
        /*Right top corner text view is removed as of now not need.
        holder.year.setText(movie.getYear());*/
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
