package pl.edu.pwr.dawidszewczyk.lab2.lab2;

import android.media.Image;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Dawid on 2017-04-09.
 */

public class Movie {
    public static final int NUMBER_OF_ACTORS = 3;
    public static final int NUMBER_OF_FRAMES = 6;

    private final Integer[] frames = {R.drawable.bttf_image, R.drawable.ij_image, R.drawable.im_image,
        R.drawable.io_image, R.drawable.martian_image, R.drawable.ra_image, R.drawable.shrek_image,
        R.drawable.sw_image, R.drawable.up_image, R.drawable.voldemort_image};

    private final Actor[] actors = { new Actor("Tomasz Karolak", R.drawable.karolak),
            new Actor("Nicolas Cage", R.drawable.cage), new Actor("Morgan Freeman", R.drawable.freeman),
            new Actor("Borys Szyc", R.drawable.szyc), new Actor("Kevin Spacey", R.drawable.spacey),
            new Actor("Sylvester Stallone", R.drawable.stallone), new Actor("Arnold Schwarzenegger", R.drawable.schwarzenegger),
            new Actor("Angelina Jolie", R.drawable.jolie)};

    private String title, genre, year;
    private String description;
    private int imageId;
    private boolean selected;
    private List<Integer> movieFrames;
    private List<Actor> movieActors;

    public Movie() {}

    public Movie(String title, String genre, String year, int imageId) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.imageId = imageId;
        description = "Blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah" +
                " blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah";
        selected = false;
        movieFrames = generateFramesList();
        movieActors = generateActorsList();
    }

    public List<Integer> generateFramesList() {
        List<Integer> framesList = new ArrayList<>(Arrays.asList(frames));
        Random rand = new Random();
        int n = frames.length - NUMBER_OF_FRAMES;
        for(int i = 0; i < n; i++) {
            int index = rand.nextInt(framesList.size());
            framesList.remove(index);
        }
        return framesList;
    }

    public List<Actor> generateActorsList() {
        List<Actor> actorsList = new ArrayList<>(Arrays.asList(actors));
        Random rand = new Random();
        int n = actors.length - NUMBER_OF_ACTORS;
        for(int i = 0; i < n; i++) {
            int index = rand.nextInt(actorsList.size());
            actorsList.remove(index);
        }
        return actorsList;
    }

    public void changeSelection() {
        selected = !selected;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public int getImage() {
        return imageId;
    }
    public void setImage(int imageId) {
        this.imageId = imageId;
    }
    public boolean getSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public Actor getActor(int index) {
        return movieActors.get(index);
    }
    public Integer getFrame(int index) {
        return movieFrames.get(index);
    }
}