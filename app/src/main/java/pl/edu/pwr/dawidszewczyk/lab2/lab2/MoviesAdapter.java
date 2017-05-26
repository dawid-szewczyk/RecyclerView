package pl.edu.pwr.dawidszewczyk.lab2.lab2;

/**
 * Created by Dawid on 2017-04-09.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movie> moviesList;

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView image, eyeImage;

        public MoviesViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            image = (ImageView) view.findViewById(R.id.image);
            eyeImage = (ImageView) view.findViewById(R.id.eye);
        }
    }

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public int getItemViewType(int position){
        return position % 2;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = viewType == 0 ? R.layout.movie_list_row : R.layout.movie_list_row_reversed;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new MoviesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.image.setImageResource(movie.getImage());
        holder.eyeImage.setVisibility(movie.getSelected() ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
