package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by daniel on 12/07/2017.
 */

public class ScrollViewActivity extends AppCompatActivity {

    private LinearLayout _scrollContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);

        _scrollContainer = (LinearLayout) findViewById(R.id.Container);

        addExampleImage(10);
    }


    public void addToStart(View v)
    {
        ImageView temp = buildImage();
        _scrollContainer.addView(temp, 0);
    }

    public void addToEnd(View v)
    {
        ImageView temp = buildImage();
        _scrollContainer.addView(temp);
    }

    public boolean _isInverted = false;

    public void changeInvert(View v)
    {
        Button invertionButton = (Button)v;
        _isInverted = !_isInverted;

        if (_isInverted)
        {
            invertionButton.setText("Normal");
        }
        else
        {
            invertionButton.setText("Invert");
        }

        //_layoutManager.setReverseLayout(_isInverted);
        //_layoutManager.setStackFromEnd(_isInverted);
        //_flagsAdapter.notifyDataSetChanged();
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

    private void addExampleImage(int amountOfImages)
    {
        for (int i=0; i < amountOfImages; i++)
            _scrollContainer.addView(buildImage());
    }

    private int getRandomFlagId()
    {
        final TypedArray imgs = getResources().obtainTypedArray(R.array.images);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }
}
