package com.poc.scroller.locable.lockablescrollerpoc;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity extends AppCompatActivity {

    private List<FlagResource> flagsList = new ArrayList<>();
    private FlagResourceAdapter _flagsAdapter;
    private RecyclerView _recyclerView;
    private LinearLayoutManager _layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);

        _recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        _flagsAdapter = new FlagResourceAdapter(flagsList);
        _layoutManager = new LinearLayoutManager(getApplicationContext());
        _recyclerView.setLayoutManager(_layoutManager);
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(_flagsAdapter);

        prepareFlagData(50);
    }

    public void prepareFlagData(int amount) {
        for (int i = 0; i < amount; i++) {
            FlagResource flag = new FlagResource(getRandomFlagId());
            flagsList.add(flag);
        }

        _flagsAdapter.notifyDataSetChanged();
    }

    public void addToStart(View v)
    {
        FlagResource flag = new FlagResource(getRandomFlagId());
        flagsList.add(0, flag);
        _flagsAdapter.notifyItemInserted(0);
    }

    public void addToEnd(View v)
    {
        FlagResource flag = new FlagResource(getRandomFlagId());
        flagsList.add(flag);
        _flagsAdapter.notifyDataSetChanged();
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

        _layoutManager.setReverseLayout(_isInverted);
        _layoutManager.setStackFromEnd(_isInverted);
        _flagsAdapter.notifyDataSetChanged();
    }

    private int getRandomFlagId()
    {
        final TypedArray imgs = getResources().obtainTypedArray(R.array.images);
        final Random rand = new Random();
        final int rndInt = rand.nextInt(imgs.length());
        return imgs.getResourceId(rndInt, 0);
    }
}
