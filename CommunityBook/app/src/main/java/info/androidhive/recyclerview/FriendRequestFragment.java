package info.androidhive.recyclerview;

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

public class FriendRequestFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<FriendRequestBean> friendRequestBeanArrayList = new ArrayList<>();
    FriendRequestListAdapter friendRequestListAdapter;
    FriendRequestBean friendRequestBean;

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
        friendRequestListAdapter = new FriendRequestListAdapter(friendRequestBeanArrayList, getActivity());
        recyclerView.setAdapter(friendRequestListAdapter);
    }


    private void inflateCommentsList(){
        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Yash Agarwal");
        friendRequestBean.setMutualFriends("11 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Ruhi Ranjan");
        friendRequestBean.setMutualFriends("1 Mutual Friend");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Romy Walia");
        friendRequestBean.setMutualFriends("2 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Kartik Shankar");
        friendRequestBean.setMutualFriends("");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Amit Tandel");
        friendRequestBean.setMutualFriends("8 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Aarti Patwardhan");
        friendRequestBean.setMutualFriends("3 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Manohar Reddy");
        friendRequestBean.setMutualFriends("33 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Suresh Anand");
        friendRequestBean.setMutualFriends("");
        friendRequestBeanArrayList.add(friendRequestBean);

        friendRequestBean = new FriendRequestBean();
        friendRequestBean.setName("Rachna Deshpande");
        friendRequestBean.setMutualFriends("11 Mutual Friends");
        friendRequestBeanArrayList.add(friendRequestBean);


    }
}

