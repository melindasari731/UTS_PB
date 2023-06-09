package com.example.myrukunshalatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_rukun;
    private final ArrayList<Rukun> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_rukun = findViewById(R.id.rvRukun);
        rv_rukun.setHasFixedSize(true);

        list.addAll(DataRukun.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rv_rukun.setLayoutManager(new LinearLayoutManager(this));
        CardViewRukun cardViewRukun = new CardViewRukun(list);
        rv_rukun.setAdapter(cardViewRukun);

        cardViewRukun.setOnItemClickCallback(new CardViewRukun.OnItemClickCallback() {
            @Override
            public void onItemClicked(Rukun rukun) {
                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.ITEM_EXTRA, String.valueOf(rukun));
                startActivity(move);
            }
        });
    }

}