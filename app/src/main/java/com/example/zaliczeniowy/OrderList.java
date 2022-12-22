package com.example.zaliczeniowy;

import android.widget.Adapter;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter RecyclerAdapter;

    String [] order_text = {"pierwszy ","drugi ","trzeci ","czwarty "};
    String [] order_price = {"1 ","2 ","3 ","4 "};
    int [] order_image = {R.drawable.kamera1,R.drawable.klawiatura1,R.drawable.rival1,R.drawable.zestaw1};

    public OrderList() {
        setContentView(R.layout.order_list);
        recyclerView = findViewById(R.id.recycler_items);
        recyclerView.setHasFixedSize(true);
//        RecyclerAdapter = new RecyclerAdapter();

    }

    //        recyclerView = findViewById(R.id.recycler_items);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new RelativeLayout();

}
