package com.example.mike.drinkspap.Delegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.drinkspap.Adapters.MainAdapter;
import com.example.mike.drinkspap.Pojo.CategoryObject;
import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.MainDrinksObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.R;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class MainDrinksDelegate extends AdapterDelegate<List<MainObject>> {
    private final LayoutInflater inflater;
    private final Context context;

    public MainDrinksDelegate(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    protected boolean isForViewType(@NonNull List<MainObject> items, int position) {
        return items.get(position) instanceof MainDrinksObject;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new MainDrinksDelegate.MainDrinksDelegateViewHolder(inflater.inflate(R.layout.maindrinks_item,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<MainObject> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        MainDrinksObject object = (MainDrinksObject) items.get(position);
        MainDrinksDelegate.MainDrinksDelegateViewHolder categoryViewHolder = (MainDrinksDelegate.MainDrinksDelegateViewHolder) holder;

        List<MainObject> drinksObjects = new ArrayList<>();

        for (DrinksObject drinksObject : object.getMainObjects()){
            drinksObjects.add(drinksObject);
        }

        MainAdapter adapter = new MainAdapter(context,drinksObjects);
        categoryViewHolder.recyclerView.setAdapter(adapter);
        categoryViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
    }

    private class MainDrinksDelegateViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public MainDrinksDelegateViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.view_maindrinks);
        }
    }
}
