package com.poc.scroller.locable.lockablescrollerpoc;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

public class FlagResourceAdapter extends RecyclerView.Adapter<FlagResourceAdapter.MyViewHolder> {
    private List<FlagResource> flagsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView flag;

        public MyViewHolder(View view) {
            super(view);

            flag = (ImageView) view.findViewById(R.id.country);
        }
    }

    public FlagResourceAdapter(List<FlagResource> flagsList) {
        this.flagsList = flagsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flag, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FlagResource flag = flagsList.get(position);
        holder.flag.setImageResource(flag.getFlagResource());

        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams)holder.flag.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        holder.flag.setLayoutParams(layoutParams);

        holder.flag.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return flagsList.size();
    }
}
