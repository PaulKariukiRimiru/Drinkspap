package com.example.mike.drinkspap.Pojo;

import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class TiltleObject extends MainObject {
    String title;
    List<DrinksObject> drinksObjects;

    public List<DrinksObject> getDrinksObjects() {
        return drinksObjects;
    }

    public void setDrinksObjects(List<DrinksObject> drinksObjects) {
        this.drinksObjects = drinksObjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
