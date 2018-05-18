package com.arturofilio.arturoconsulting.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arturofilio.arturoconsulting.Interface.ItemClickListener;
import com.arturofilio.arturoconsulting.R;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    private ImageView image;
    private TextView text;

    private ItemClickListener itemClickListener;

     public RecyclerViewHolder(View itemView) {
        super(itemView);
//        image = (ImageView) itemView.findViewById(R.id.item_exercise);
    }

    @Override
    public void onClick(View v) {

    }
}

public class RecyclerViewAdapter {
}
