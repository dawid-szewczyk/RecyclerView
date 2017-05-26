package pl.edu.pwr.dawidszewczyk.lab2.lab2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pl.edu.pwr.dawidszewczyk.lab2.lab2.MainActivity;
import pl.edu.pwr.dawidszewczyk.lab2.lab2.Movie;
import pl.edu.pwr.dawidszewczyk.lab2.lab2.R;

public class ActorsFragment extends Fragment {
    int index;
    TextView tvActor1;
    TextView tvActor2;
    TextView tvActor3;
    ImageView ivActor1;
    ImageView ivActor2;
    ImageView ivActor3;

    public ActorsFragment() {}

    public static ActorsFragment newInstance(int index) {
        ActorsFragment fragment = new ActorsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MainActivity.MOVIE_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getArguments().getInt(MainActivity.MOVIE_INDEX);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actors, container, false);
        tvActor1 = (TextView) view.findViewById(R.id.tvActor1);
        tvActor2 = (TextView) view.findViewById(R.id.tvActor2);
        tvActor3 = (TextView) view.findViewById(R.id.tvActor3);
        ivActor1 = (ImageView) view.findViewById(R.id.ivActor1);
        ivActor2 = (ImageView) view.findViewById(R.id.ivActor2);
        ivActor3 = (ImageView) view.findViewById(R.id.ivActor3);
        return view;
    }

    public void setContent() {
        Movie movie = MainActivity.movieList.get(index);
        tvActor1.setText(movie.getActor(0).getName());
        tvActor2.setText(movie.getActor(1).getName());
        tvActor3.setText(movie.getActor(2).getName());
        ivActor1.setImageResource(movie.getActor(0).getImageId());
        ivActor2.setImageResource(movie.getActor(1).getImageId());
        ivActor3.setImageResource(movie.getActor(2).getImageId());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContent();
    }
}
