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

public class ImagesFragment extends Fragment {
    int index;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;

    public ImagesFragment() {}

    public static ImagesFragment newInstance(int index) {
        ImagesFragment fragment = new ImagesFragment();
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
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        imageView4 = (ImageView) view.findViewById(R.id.imageView4);
        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        imageView6 = (ImageView) view.findViewById(R.id.imageView6);
        return view;
    }

    public void setContent() {
        Movie movie = MainActivity.movieList.get(index);
        imageView1.setImageResource(movie.getFrame(0));
        imageView2.setImageResource(movie.getFrame(1));
        imageView3.setImageResource(movie.getFrame(2));
        imageView4.setImageResource(movie.getFrame(3));
        imageView5.setImageResource(movie.getFrame(4));
        imageView6.setImageResource(movie.getFrame(5));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContent();
    }
}
