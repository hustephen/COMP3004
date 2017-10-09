package com.example.androidtemplate;


import com.example.androidtemplate.common.CommonAdapter;
import com.example.androidtemplate.common.Constants;
import com.example.androidtemplate.common.ViewHolder;
import com.example.androidtemplate.manager.ManagerComm;
import com.example.androidtemplate.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import com.example.androidtemplate.common.T;
import com.example.androidtemplate.manager.ManagerConf;
import com.example.androidtemplate.common.D;
import com.example.androidtemplate.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;

import com.example.androidtemplate.common.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    protected void initData() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void recycle() {

    }
}
