package com.example.arxdev30.testrecycler.logic;

import android.util.Log;

import com.example.arxdev30.testrecycler.Data.DataSourceInterface;
import com.example.arxdev30.testrecycler.Data.ListItem;
import com.example.arxdev30.testrecycler.view.ViewInterface;

/**
 * Created by nikos on 3/8/2017.
 */

public class Controller {
    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(dataSource.getListOfData());
    }

    public void onListItemClick(ListItem Item) {
        Log.d("TAG", "onListItemClick: " + Item.getDateAndTime() + " " + Item.getMessage() + " " + Item.getColorResource());
        view.startDetailActivity(Item.getDateAndTime(), Item.getMessage(), Item.getColorResource());
    }
}
