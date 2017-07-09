package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout _container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _container = (LinearLayout)findViewById(R.id.Container);
        addExampleImage(20);
    }

    public void addToStart(View v)
    {
        ImageView temp = buildImage();
        _container.addView(temp, 0);
    }

    public void addToEnd(View v)
    {
        ImageView temp = buildImage();
        _container.addView(temp);
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
            _container.addView(buildImage());
    }

    private int getRandomFlagId()
    {
        final TypedArray imgs = getResources().obtainTypedArray(R.array.images);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }
}
