package com.example.mike.drinkspap.Delegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.example.mike.drinkspap.Fragments.ProductFragment;
import com.example.mike.drinkspap.Interfaces.NavigationInterface;
import com.example.mike.drinkspap.Pojo.DeliveriesObject;
import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.R;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class DeliveriesDelegate extends AdapterDelegate<List<MainObject>> {

    private final LayoutInflater inflater;
    private final Context context;
    private final NavigationInterface navigationInterface;

    public DeliveriesDelegate(Context context, NavigationInterface navigationInterface){
        inflater = LayoutInflater.from(context);
        this.navigationInterface = navigationInterface;
        this.context = context;
    }

    @Override
    protected boolean isForViewType(@NonNull List<MainObject> items, int position) {
        return items.get(position) instanceof DeliveriesObject;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new DrinksDelegateViewHolder(inflater.inflate(R.layout.delivery_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<MainObject> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {

    }

    private class DrinksDelegateViewHolder extends RecyclerView.ViewHolder{

        public DrinksDelegateViewHolder(View itemView) {
            super(itemView);

        }
    }

}
