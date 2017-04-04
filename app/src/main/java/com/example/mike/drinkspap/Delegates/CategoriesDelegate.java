package com.example.mike.drinkspap.Delegates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mike.drinkspap.Adapters.MainAdapter;
import com.example.mike.drinkspap.Interfaces.NavigationInterface;
import com.example.mike.drinkspap.Pojo.CategoryObject;
import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.R;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class CategoriesDelegate extends AdapterDelegate<List<MainObject>> {

    private final LayoutInflater inflater;
    private final Context context;
    private final NavigationInterface navigationInterface;

    public CategoriesDelegate(Context context, NavigationInterface navigationInterface){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.navigationInterface = navigationInterface;
    }


    @Override
    protected boolean isForViewType(@NonNull List<MainObject> items, int position) {
        return items.get(position) instanceof CategoryObject;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new CategoryViewHolder(inflater.inflate(R.layout.category_item,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<MainObject> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        CategoryObject object = (CategoryObject) items.get(position);
        CategoryViewHolder categoryViewHolder = (CategoryViewHolder) holder;

        categoryViewHolder.textView.setText(object.getTitle());

        List<MainObject> drinksObjects = new ArrayList<>();

        for (DrinksObject drinksObject : object.getData()){
            drinksObjects.add(drinksObject);
        }


        MainAdapter adapter = new MainAdapter(context, drinksObjects,navigationInterface);
        categoryViewHolder.recyclerView.setAdapter(adapter);
        categoryViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder{
        AppCompatTextView textView;
        RecyclerView recyclerView;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            textView = (AppCompatTextView) itemView.findViewById(R.id.tvHeader);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.sec_view);
        }
    }

}
