package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout _container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _container = (LinearLayout)findViewById(R.id.Container);
        createExampleImage(20);
    }

    private void createExampleImage(int amountOfImages)
    {
        for (int i=0; i < amountOfImages; i++) {

            ImageView temp = new ImageView(this);
            temp.setImageResource(getRandomFlagId());

            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(200, 200);
            parms.gravity = Gravity.CENTER;

            temp.setLayoutParams(parms);

            _container.addView(temp);
        }
    }

    private int getRandomFlagId()
    {
        final TypedArray imgs = getResources().obtainTypedArray(R.array.images);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }
}
