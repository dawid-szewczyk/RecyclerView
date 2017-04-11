package pl.edu.pwr.dawidszewczyk.lab2.lab2;

import android.view.View;

/**
 * Created by Dawid on 2017-04-09.
 */

public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}