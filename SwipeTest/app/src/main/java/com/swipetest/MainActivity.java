package com.swipetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snaprecycler.SnapRecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SnapRecyclerView swipeRecycler = (SnapRecyclerView)findViewById(R.id.swipeRecylcer);
        swipeRecycler.setVisibleItemCount(3, 20, 0, 20, 0);

        swipeRecycler.setAdapter(new SwipeAdapter());

    }

}
