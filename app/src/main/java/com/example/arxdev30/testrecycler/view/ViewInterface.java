package com.example.arxdev30.testrecycler.view;

import com.example.arxdev30.testrecycler.Data.ListItem;

import java.util.List;

/**
 * Created by nikos on 3/8/2017.
 */

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);
}
