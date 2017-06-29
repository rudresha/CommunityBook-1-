package communitybook.android.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FriendRequestListAdapter extends RecyclerView.Adapter<FriendRequestListAdapter.MyViewHolder> {

    private List<FriendRequestBean> friendRequestBeanList;
    Context mContext;
    Activity mActiivty;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtMutualFriends;

        public MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtMutualFriends = (TextView) view.findViewById(R.id.txt_mutual_friends);
        }
    }


    public FriendRequestListAdapter(List<FriendRequestBean> friendRequestBeanList, Activity activity) {
        this.friendRequestBeanList = friendRequestBeanList;
        mActiivty = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_request_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FriendRequestBean friendRequestBean = friendRequestBeanList.get(position);
        holder.txtName.setText(friendRequestBean.getName());
        if (friendRequestBean.getMutualFriends().trim().length() > 0) {
            holder.txtMutualFriends.setVisibility(View.VISIBLE);
            holder.txtMutualFriends.setText(friendRequestBean.getMutualFriends());
        }else
            holder.txtMutualFriends.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return friendRequestBeanList.size();
    }
}
