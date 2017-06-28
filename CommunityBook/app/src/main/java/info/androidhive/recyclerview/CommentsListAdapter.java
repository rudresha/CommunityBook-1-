package info.androidhive.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CommentsListAdapter extends RecyclerView.Adapter<CommentsListAdapter.MyViewHolder> implements View.OnClickListener {

    private List<CommentsBean> commentsList;
    Context mContext;
    Activity mActiivty;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_comment:
                CommentsDialogFragment commentsDialogFragment = new CommentsDialogFragment();
                commentsDialogFragment.show(mActiivty.getFragmentManager(), "dialog");

                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtComments;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtComments = (TextView) view.findViewById(R.id.txt_comments);
        }
    }


    public CommentsListAdapter(List<CommentsBean> commentsList, Activity activity) {
        this.commentsList = commentsList;
        mActiivty = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comments_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CommentsBean commentsBean = commentsList.get(position);
        holder.txtComments.setText(commentsBean.getComments());
        holder.txtName.setText(commentsBean.getName());

    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }
}
