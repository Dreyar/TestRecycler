package com.example.arxdev30.testrecycler.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arxdev30.testrecycler.Data.FakeDataSource;
import com.example.arxdev30.testrecycler.Data.ListItem;
import com.example.arxdev30.testrecycler.R;
import com.example.arxdev30.testrecycler.logic.Controller;


import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfDate;
    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();
        controller = new Controller(this, new FakeDataSource());
    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent i = new Intent(ListActivity.this, DetailActivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        i.putExtra(EXTRA_MESSAGE, message);
        i.putExtra(EXTRA_COLOR, colorResource);
        startActivity(i);
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfDate = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {//6

        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomAdapter.CustomViewHolder holder, int position) {
            ListItem currentItem = listOfDate.get(position);

            holder.coloredCircle.setImageResource(currentItem.getColorResource());

            holder.message.setText(currentItem.getMessage());

            holder.dateAndTime.setText(currentItem.getDateAndTime());

        }

        @Override
        public int getItemCount() {
            // 12. Returning 0 here will tell our Adapter not to make any Items. Let's fix that.
            return listOfDate.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            //10. now that we've made our layouts, let's bind them
            private ImageView coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);
                this.coloredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.dateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_time);
                this.message = (TextView) itemView.findViewById(R.id.lbl_message);

                this.container = (ViewGroup) itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfDate.get(this.getAdapterPosition());

                controller.onListItemClick(listItem);

            }
        }
    }

}