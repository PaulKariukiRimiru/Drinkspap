package com.example.mike.drinkspap.Pojo;

import java.util.List;

/**
 * Created by Mike on 4/3/2017.
 */

public class CategoryObject extends MainObject {
    String Title;
    List<DrinksObject> data;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public List<DrinksObject> getData() {
        return data;
    }

    public void setData(List<DrinksObject> data) {
        this.data = data;
    }
}
