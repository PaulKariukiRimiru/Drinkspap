package com.example.mike.drinkspap.Pojo;

import java.util.List;

/**
 * Created by Mike on 4/4/2017.
 */

public class MainDrinksObject extends MainObject {
    List<DrinksObject> mainObjects;

    public List<DrinksObject> getMainObjects() {
        return mainObjects;
    }

    public void setMainObjects(List<DrinksObject> mainObjects) {
        this.mainObjects = mainObjects;
    }
}
