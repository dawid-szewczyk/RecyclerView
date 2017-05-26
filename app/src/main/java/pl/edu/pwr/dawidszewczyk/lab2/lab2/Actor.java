package pl.edu.pwr.dawidszewczyk.lab2.lab2;
import java.io.Serializable;

/**
 * Created by Dawid on 2017-05-23.
 */

public class Actor {
    int imageId;
    String name;

    public Actor(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
