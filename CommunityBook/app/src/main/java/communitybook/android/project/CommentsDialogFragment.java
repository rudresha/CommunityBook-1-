package communitybook.android.project;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by rudresha on 10/06/17.
 */

public class CommentsDialogFragment extends DialogFragment implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<CommentsBean> commentsList = new ArrayList<>();
    CommentsListAdapter commentsListAdapter;
    CommentsBean commentsBean;
    EditText edtComments;
    Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comments_dialog, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        edtComments = (EditText) view.findViewById(R.id.edt_comments);
        btnSubmit = (Button) view.findViewById(R.id.btn_enter);

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
        commentsListAdapter = new CommentsListAdapter(commentsList, getActivity());
        recyclerView.setAdapter(commentsListAdapter);
        btnSubmit.setOnClickListener(this);
    }

    private void inflateCommentsList(){
        commentsBean = new CommentsBean();
        commentsBean.setComments("Awesome");
        commentsBean.setName("Sunny D'Souza");
        commentsList.add(commentsBean);

        commentsBean = new CommentsBean();
        commentsBean.setComments("Nice Pic");
        commentsBean.setName("Priya Kapoor");
        commentsList.add(commentsBean);

        commentsBean = new CommentsBean();
        commentsBean.setComments("Which is this place mate?");
        commentsBean.setName("Rohit Singh Thakur");
        commentsList.add(commentsBean);


        commentsBean = new CommentsBean();
        commentsBean.setComments("Ohhhh Someoneis bck!!");
        commentsBean.setName("DJ Rocks");
        commentsList.add(commentsBean);


        commentsBean = new CommentsBean();
        commentsBean.setComments("U forgot me..!..");
        commentsBean.setName("Vivek Mishra");
        commentsList.add(commentsBean);

        commentsBean = new CommentsBean();
        commentsBean.setComments("Lets do this agn dude");
        commentsBean.setName("Raju Mehta");
        commentsList.add(commentsBean);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_enter:
                if(edtComments.getText().toString().trim().length()>0){
                    commentsBean = new CommentsBean();
                    commentsBean.setComments(edtComments.getText().toString());
                    commentsBean.setName("You");
                    edtComments.setText("");
                    commentsList.add(commentsBean);
                    commentsListAdapter.notifyDataSetChanged();

                }

                break;
        }
    }
}
