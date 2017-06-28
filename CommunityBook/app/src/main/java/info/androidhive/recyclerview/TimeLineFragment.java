package info.androidhive.recyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rudresha on 22/06/17.
 */

public class TimeLineFragment extends Fragment {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.timeline_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        initListeners();
        return  view;

    }

    private void initListeners() {
        mAdapter = new MoviesAdapter(movieList,getActivity());
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

    }

    private void prepareMovieData() {
        Movie movie = new Movie("Rajesh", "Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Sumit", "Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Kuldip", "Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Romita", "Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("Rupali", "The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Hema", "Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Neha", "Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Rohan", "Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("Anil", "The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Anannd", "Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Amitab", "Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Bhairav", "Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Hardik", "Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Rohit", "Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Sandeep", "Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Mohit", "Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();

    }
}

