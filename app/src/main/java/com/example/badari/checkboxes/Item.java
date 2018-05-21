package com.example.badari.checkboxes;

/**
 * Created by Badari on 18-05-2018.
 */

public class Item {

    private String item;


    public Item() {
        // This is default constructor.
    }

    public String getitemselected(String item) {

this.item=item;
        return item;
    }

    public void setitemselected(String item) {

        this.item = item;
    }

}
