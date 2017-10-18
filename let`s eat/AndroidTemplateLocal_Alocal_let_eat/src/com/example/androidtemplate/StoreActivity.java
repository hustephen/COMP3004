package com.example.androidtemplate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.androidtemplate.common.BaseActivity;
import com.example.androidtemplate.mo.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoreActivity extends BaseActivity {

    @Bind(R.id.left_tv)
    TextView leftTv;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.right_tv)
    TextView rightTv;
    @Bind(R.id.title_ll)
    LinearLayout titleLl;
    @Bind(R.id.img_iv)
    ImageView imgIv;
    @Bind(R.id.address_et)
    TextView addressEt;
    @Bind(R.id.cuisine_et)
    TextView cuisineEt;
    @Bind(R.id.price_et)
    TextView priceEt;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;
    @Bind(R.id.random_btn)
    Button randomBtn;
    @Bind(R.id.content_ll)
    LinearLayout contentLl;

    List<Store> storeList = new ArrayList<Store>();



    @Override
    protected void initData() {
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);

        storeList.add(new Store("Thai Coconut",R.drawable.s_one,"1390 Prince of Wales Dr","Thailand food","25",3,45.369306, -75.703409));

        storeList.add(new Store("Ben Ben Restaurant",R.drawable.s_two,"697 Somerset St W","Chinese food","12",4,45.411131, -75.706966));

        storeList.add(new Store("The Hintonburg Public House",R.drawable.s_three,"1020 Wellington St W, Ottawa, ON K1Y 2X9","Hamburg","18",3,45.404575, -75.723597));

        storeList.add(new Store("Open Rice",R.drawable.s_four,"1755 St Laurent Blvd, Ottawa, ON K1G 3V4","Chinese food","12",4,45.4049962, -75.6255558));

        show();

    }

    private int position = -1;
    Store store;
    private void show(){

        while (true){
            int max=3;
            int min=0;
            Random random = new Random();
            int s = random.nextInt(max)%(max-min+1) + min;
            if(s!=position){
                position = s;
                break;
            }
        }

        store = storeList.get(position);

        imgIv.setImageDrawable(getResources().getDrawable(store.getImg()));
        addressEt.setText(store.getAddress());
        cuisineEt.setText(store.getCuisine());
        priceEt.setText(store.getPrice());

        ratingBar.setRating(store.getRating());
        ratingBar.setIsIndicator(false);
    }

    @Override
    protected void recycle() {

    }


    @OnClick({R.id.left_tv, R.id.right_tv, R.id.random_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_tv:
                finish();
                break;
            case R.id.right_tv:
                startActivity(new Intent(this_,MapsActivity.class).putExtra("lat",store.getLat()).putExtra("lng",store.getLng()));
                break;
            case R.id.random_btn:
                show();
                break;
        }
    }
}
