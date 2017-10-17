package com.example.androidtemplate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidtemplate.common.BaseActivity;
import com.example.androidtemplate.manager.ManagerApp;
import com.example.androidtemplate.mo.Store;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainNewActivity extends BaseActivity {

    @Bind(R.id.left_tv)
    TextView leftTv;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.right_tv)
    TextView rightTv;
    @Bind(R.id.title_ll)
    LinearLayout titleLl;
    @Bind(R.id.distance_sp)
    Spinner distanceSp;
    @Bind(R.id.cuisine_sp)
    Spinner cuisineSp;
    @Bind(R.id.price_sp)
    Spinner priceSp;
    @Bind(R.id.ratingBar)
    RatingBar ratingBar;
    @Bind(R.id.register_btn)
    Button registerBtn;
    @Bind(R.id.content_ll)
    LinearLayout contentLl;



    @Override
    protected void initData() {
        setContentView(R.layout.activity_main_new);
        ButterKnife.bind(this);



    }

    @Override
    protected void recycle() {

    }


    @OnClick({R.id.left_tv, R.id.right_tv, R.id.register_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_tv:
                ManagerApp.exitApp();
                break;
            case R.id.right_tv:
                break;
            case R.id.register_btn:

                //String cuisine = cuisineSp.getSelectedItem().toString();

                //for()

                startActivity(new Intent(this_,StoreActivity.class));

                break;
        }
    }
}
