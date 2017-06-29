package communitybook.android.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by rudresha on 22/06/17.
 */

public class NotificationsFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<NotificationsBean> notificationsList = new ArrayList<>();
    NotificationsListAdapter notificationsListAdapter;
    NotificationsBean notificationsBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        inflateCommentsList();
        initListeners();

        return view;
    }

    private void initListeners(){
        notificationsListAdapter = new NotificationsListAdapter(notificationsList, getActivity());
        recyclerView.setAdapter(notificationsListAdapter);
    }


    private void inflateCommentsList(){
        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b>Sunny D'Souza </b> and <b>Vijay Kumar</b> have birthdays today. Send them good thoughts!");
        notificationsBean.setNotificationDate("11 hours ago");
        notificationsList.add(notificationsBean);

        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b>Rohit Singh Thakur</b> likes your album <b> Random Pics</b>");
        notificationsBean.setNotificationDate("Yesterday at 11.09 AM");
        notificationsList.add(notificationsBean);

        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Viviek Mishra </b> recently added a new photo");
        notificationsBean.setNotificationDate("Fri at 10.30 PM");
        notificationsList.add(notificationsBean);


        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Raju Mehta </b> and <b>Karan Rathod</b> recently reacted to your Photo");
        notificationsBean.setNotificationDate("Wed at 1:00 PM");
        notificationsList.add(notificationsBean);


        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Sanaya Thakkar, Manu Menon</b> and <b> 4 others</b> also commented on <b> Ashok Bhatti's </b> post");
        notificationsBean.setNotificationDate("Wed at 10:06 AM");
        notificationsList.add(notificationsBean);

        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Renuka Raj</b> also replied to her comment on her post");
        notificationsBean.setNotificationDate("Wed at 08:13 AM");
        notificationsList.add(notificationsBean);

        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Dhaval Nayak</b> added a photo in <b> K J Somaiya College Of Arts And Commerce</b");
        notificationsBean.setNotificationDate("Wed at 00:13 AM");
        notificationsList.add(notificationsBean);

        notificationsBean = new NotificationsBean();
        notificationsBean.setNotification("<b> Ravi Deshpande</b> invited to like his his new Page <b> Hello Vacation</b>");
        notificationsBean.setNotificationDate("Tue at 09:45 PM");
        notificationsList.add(notificationsBean);


    }
}

