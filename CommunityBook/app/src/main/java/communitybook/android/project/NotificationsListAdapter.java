package communitybook.android.project;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.MyViewHolder> implements View.OnClickListener {

    private List<NotificationsBean> notificationsBeanList;
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

        TextView txtNotification, txtNotificationDate;

        public MyViewHolder(View view) {
            super(view);
            txtNotification = (TextView) view.findViewById(R.id.txt_notification);
            txtNotificationDate = (TextView) view.findViewById(R.id.txt_notification_date);
        }
    }


    public NotificationsListAdapter(List<NotificationsBean> notificationsBeanList, Activity activity) {
        this.notificationsBeanList = notificationsBeanList;
        mActiivty = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notifications_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotificationsBean notificationsBean = notificationsBeanList.get(position);
        holder.txtNotification.setText(Html.fromHtml(notificationsBean.getNotification()));
        /*holder.txtNotification.setText(Html.fromHtml("<b>Your title here</b>\n" +
                "This is the non-bolded stuff."));*/
        holder.txtNotificationDate.setText(notificationsBean.getNotificationDate());

    }

    @Override
    public int getItemCount() {
        return notificationsBeanList.size();
    }
}
