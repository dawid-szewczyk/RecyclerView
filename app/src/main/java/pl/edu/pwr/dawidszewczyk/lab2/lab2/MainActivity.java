package pl.edu.pwr.dawidszewczyk.lab2.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String MOVIE_INDEX = "movie_index";

    public static List<Movie> movieList = new ArrayList<>(Arrays.asList(
            new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.mad_max),
            new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.inside_out),
            new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015", R.drawable.star_wars),
            new Movie("Shaun the Sheep", "Animation", "2015", R.drawable.shaun),
            new Movie("The Martian", "Science Fiction & Fantasy", "2015", R.drawable.martian),
            new Movie("Mission: Impossible Rogue Nation", "Action", "2015", R.drawable.mission),
            new Movie("Up", "Animation", "2009", R.drawable.up),
            new Movie("Star Trek", "Science Fiction", "2009", R.drawable.star_trek),
            new Movie("The LEGO Movie", "Animation", "2014", R.drawable.lego),
            new Movie("Iron Man", "Action & Adventure", "2008", R.drawable.iron_man),
            new Movie("Aliens", "Science Fiction", "1986", R.drawable.aliens),
            new Movie("Chicken Run", "Animation", "2000", R.drawable.chicken_run),
            new Movie("Back to the Future", "Science Fiction", "1985", R.drawable.back_to_the_future),
            new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981", R.drawable.indiana_jones),
            new Movie("Goldfinger", "Action & Adventure", "1965", R.drawable.goldfinger),
            new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", R.drawable.guardians_of_the_galaxy)
    ));

    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                intent.putExtra(MOVIE_INDEX, position);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                movieList.get(position).changeSelection();
                mAdapter.notifyDataSetChanged();
            }
        }));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder view) {
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                movieList.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}