package pl.edu.pwr.dawidszewczyk.lab2.lab2.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import pl.edu.pwr.dawidszewczyk.lab2.lab2.MainActivity;
import pl.edu.pwr.dawidszewczyk.lab2.lab2.Movie;
import pl.edu.pwr.dawidszewczyk.lab2.lab2.MovieActivity;
import pl.edu.pwr.dawidszewczyk.lab2.lab2.R;

public class MovieFragment extends Fragment {
    ImageView ivPoster;
    TextView tvTitle;
    TextView tvDescription;
    RatingBar ratingBar;
    Button btnDetails;
    int index;

    public MovieFragment() {}

    public static MovieFragment newInstance(int index) {
        MovieFragment fragment = new MovieFragment();
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
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ivPoster = (ImageView)view.findViewById(R.id.ivPoster);
        tvTitle = (TextView)view.findViewById(R.id.tvTitle);
        tvDescription = (TextView)view.findViewById(R.id.tvDescription);
        ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
        btnDetails = (Button) view.findViewById(R.id.btnDetails);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setContent();
        setRatingBarListener();
        setBtnDetailsListener();
        restoreRating();
    }

    public void setContent() {
        Movie movie = MainActivity.movieList.get(index);
        ivPoster.setImageResource(movie.getImage());
        tvTitle.setText(movie.getTitle());
        tvDescription.setText(movie.getDescription());
    }

    public void setRatingBarListener() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRating(rating);
            }
        });
    }

    public void setBtnDetailsListener() {
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToDetailsFragment();
            }
        });
    }

    public void switchToDetailsFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.detach(fragmentManager.findFragmentById(R.id.movie_container));
        fragmentTransaction.add(R.id.images_fragment, ImagesFragment.newInstance(index));
        fragmentTransaction.add(R.id.actors_fragment, ActorsFragment.newInstance(index));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void saveRating(float rating) {
        SharedPreferences data = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();
        editor.putFloat(tvTitle.getText().toString(), rating);
        editor.commit();
    }

    public void restoreRating() {
        SharedPreferences data = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        float rating = data.getFloat(tvTitle.getText().toString(), 0F);
        ratingBar.setRating(rating);
    }
}
