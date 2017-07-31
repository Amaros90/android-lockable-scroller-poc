package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class ScrollViewActivity extends AppCompatActivity {

    private LinearLayout _linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);

        _linearLayout = (LinearLayout)findViewById(R.id.Container);

        addExampleImage(10, _linearLayout);
    }


    public void addToStart(View v)
    {
        ImageView temp = buildImage();
        _linearLayout.addView(temp, 0);
    }

    public void addToEnd(View v)
    {
        ImageView temp = buildImage();
        _linearLayout.addView(temp);
    }

    public void removeRandom(View v)
    {
        int toRemove = getRandomItemIndexToRemove();
        //int toRemove = 0;
        _linearLayout.removeViewAt(toRemove);

        Log.i("TEST", String.format("ITEM REMOVED AT %d", toRemove));
    }

    private int getRandomItemIndexToRemove() {
        return new Random().nextInt(_linearLayout.getChildCount());
    }

    private ImageView buildImage()
    {
        ImageView temp = new ImageView(this);
        temp.setImageResource(getRandomFlagId());

        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(250, 250);
        parms.gravity = Gravity.CENTER;

        temp.setLayoutParams(parms);

        return temp;
    }

    private void addExampleImage(int amountOfImages, LinearLayout layout)
    {
        for (int i=0; i < amountOfImages; i++)
            layout.addView(buildImage());
    }

    private int getRandomFlagId()
    {
        TypedArray imgs = getResources().obtainTypedArray(R.array.images);
        Random rand = new Random();
        int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }
}
