package com.example.mike.drinkspap.Delegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.drinkspap.Adapters.MainAdapter;
import com.example.mike.drinkspap.Interfaces.NavigationInterface;
import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.TiltleObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.R;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class DrinksTitleDelegate extends AdapterDelegate<List<MainObject>> {
    private final LayoutInflater inflater;
    private final Context context;
    private final NavigationInterface navigationInterface;

    public DrinksTitleDelegate(Context context, NavigationInterface navigationInterface){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.navigationInterface = navigationInterface;
    }


    @Override
    protected boolean isForViewType(@NonNull List<MainObject> items, int position) {
        return items.get(position) instanceof TiltleObject;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new DrinksTitleDelegate.MainDrinksDelegateViewHolder(inflater.inflate(R.layout.title,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<MainObject> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        TiltleObject object = (TiltleObject) items.get(position);
        DrinksTitleDelegate.MainDrinksDelegateViewHolder titleHolder = (DrinksTitleDelegate.MainDrinksDelegateViewHolder) holder;
        Log.d("DrinksTitleDelegate","Drawing to text at: "+position);

        titleHolder.appCompatTextView.setText(object.getTitle());
        List<MainObject> mainObjectList = new ArrayList<>();
        for (DrinksObject drinksObject : object.getDrinksObjects() ){
            mainObjectList.add(drinksObject);
        }
        titleHolder.recyclerView.setAdapter(new MainAdapter(context, mainObjectList, navigationInterface));
        titleHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
    }

    private class MainDrinksDelegateViewHolder extends RecyclerView.ViewHolder{
        AppCompatTextView appCompatTextView;
        RecyclerView recyclerView;
        public MainDrinksDelegateViewHolder(View itemView) {
            super(itemView);
            appCompatTextView = (AppCompatTextView) itemView.findViewById(R.id.tvTitle);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.view_titled);
        }
    }
}
