package com.example.myrukunshalatapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity  extends AppCompatActivity {
    private ImageView iv_item_photo;
    private TextView tvTittle, tvDetail;
    private Button btnShare;

    public static final String ITEM_EXTRA = "item_extra";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv_item_photo = findViewById(R.id.iv_item_photo);
        tvTittle = findViewById(R.id.tvTittle);
        tvDetail = findViewById(R.id.tvDetail);
        btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String bodytext = "Baca Selengkapnya Di:https://www.gramedia.com/best-seller/rukun-shalat/";
                share.putExtra(Intent.EXTRA_SUBJECT, "");
                share.putExtra(Intent.EXTRA_TEXT, bodytext);
                share = Intent.createChooser(share, " Share Via :");
                startActivity(share);
            }
        });

        Rukun rukun = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (rukun != null){
            Glide.with(this)
                    .load(rukun.getPhoto())
                    .into(iv_item_photo);
            tvTittle.setText(rukun.getNama());
            tvDetail.setText(rukun.getDetail());
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Rukun-Rukun Salat");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
