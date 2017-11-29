package com.example.androidtemplate;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.androidtemplate.common.BaseActivity;
import com.example.androidtemplate.common.D;
import com.example.androidtemplate.common.T;
import com.example.androidtemplate.manager.ManagerApp;
import com.example.androidtemplate.mo.Store;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    List<Store> storeList = new ArrayList<Store>();

    double lat;
    double lng;

    String cuisine;
    String price;
    double rating;

    String distance;


    @Override
    protected void initData() {
        setContentView(R.layout.activity_main_new);
        ButterKnife.bind(this);
        initGps();


        //storeList.add()
    }

    @Override
    protected void recycle() {
        if (locationManager != null) {
            //移除监听器
            locationManager.removeUpdates(locationListener);
        }

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
                if(location!=null){
//                    startActivity(new Intent(this_,StoreActivity.class).putExtra("lat",location.getLatitude()).putExtra("lng",location.getLongitude()).putExtra("cuisine",cuisineSp.getSelectedItem().toString())
//                    .putExtra("price",priceSp.getSelectedItem().toString()).putExtra("rating",ratingBar.getRating()).putExtra("distance",distanceSp.getSelectedItem().toString()));
                    search();
                }else{
                    T.showToast(this_,"Locate failure and open GPS location");
                }


                break;
        }
    }

/**
     * 显示地理位置经度和纬度信息
     *
     * @param location
     */
    private Location location;
    private LocationManager locationManager;
    private String locationProvider;

    private void initGps() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // 获取location对象
        location = getBestLocation(locationManager);
        if(location!=null){
            showLocation(location);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                3000, 8, new LocationListener() {

                    @Override
                    public void onStatusChanged(String provider, int status,
                                                Bundle extras) {
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                        showLocation(locationManager
                                .getLastKnownLocation(provider));
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                        showLocation(null);
                    }

                    @Override
                    public void onLocationChanged(Location location) {
                        location = getBestLocation(locationManager);// 每次都去获取GPS_PROVIDER优先的location对象
                        showLocation(location);
                    }
                });
    }

    private void showLocation(Location location) {

        if (this.location == null) {
            this.location = location;
        }else{
            String locationStr = "维度：" + location.getLatitude() + "\n"
                    + "经度：" + location.getLongitude();
            D.out(locationStr);
        }

    }

    /**
     * 获取location对象，优先以GPS_PROVIDER获取location对象，当以GPS_PROVIDER获取到的locaiton为null时
     * ，则以NETWORK_PROVIDER获取location对象，这样可保证在室内开启网络连接的状态下获取到的location对象不为空
     *
     * @param locationManager
     * @return
     */
    private Location getBestLocation(LocationManager locationManager) {
        Location result = null;
        if (locationManager != null) {
            result = locationManager
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (result != null) {
                return result;
            } else {
                result = locationManager
                        .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                return result;
            }
        }
        return result;
    }

    /**
     * LocationListern监听器
     * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器
     */

    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle arg2) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {
            //If the position changes, re-display
            showLocation(location);

        }
    };



    private int position = -1;
    Store store;
    private void search(){

        lat = location.getLatitude();
        lng = location.getLongitude();
        cuisine = cuisineSp.getSelectedItem().toString();
        price = priceSp.getSelectedItem().toString();
        rating = ratingBar.getRating();
        distance = distanceSp.getSelectedItem().toString();

        D.out("lat:"+lat+" lng:"+lng+" cuisine:"+cuisine+" price:"+price+" rating:"+rating+" distance:"+distance);

        List<Store> stores = new ArrayList<>();
        for(Store store:storeList){
            double distanceTemp = getDistance(new LatLng(lat,lng),new LatLng(store.getLat(),store.getLng()));

            D.out("distanceTemp:"+distanceTemp);

            switch (distance){
                case "Less than 1000m":
                    if(distanceTemp<1000){
                        addStore(store,stores);
                    }
                    break;
                case "1000m ~ 3000m":

                    if(distanceTemp>=1000 && distanceTemp<3000){
                        addStore(store,stores);
                    }

                    break;
                case "More than 3000m":
                    if(distanceTemp>=3000){
                        addStore(store,stores);
                    }
                    break;
            }
        }

        D.out("stores:"+stores);

        ArrayList<Store> storeList = new ArrayList<>();
        for(Store store:stores){
            switch (price){
                case "$10 the following":
                    if(Double.parseDouble(store.getPrice())<10){
                        storeList.add(store);
                    }
                    break;
                case "$10~20":
                    if(Double.parseDouble(store.getPrice())>=10 && Double.parseDouble(store.getPrice())<20){
                        storeList.add(store);
                    }
                    break;
                case "$20-40":
                    if(Double.parseDouble(store.getPrice())>=20 && Double.parseDouble(store.getPrice())<40){
                        storeList.add(store);
                    }
                    break;
                case "$40-80":
                    if(Double.parseDouble(store.getPrice())>=40 && Double.parseDouble(store.getPrice())<80){
                        storeList.add(store);
                    }
                    break;
                case "More than $80":
                    if(Double.parseDouble(store.getPrice())>=80){
                        storeList.add(store);
                    }
                    break;
            }
        }


        D.out("storeList:"+storeList);
        if(!storeList.isEmpty()){
            startActivity(new Intent(this_,StoreActivity.class).putParcelableArrayListExtra("store",storeList));
        }else{
            T.showToast(this_,"The search results are empty");
        }

}

    private void addStore(Store store,List list){
        if(store.getCuisine().equals(cuisine) && store.getRating()>=rating){
            list.add(store);
        }
    }

    public double getDistance(LatLng start, LatLng end){
        double lat1 = (Math.PI/180)*start.latitude;
        double lat2 = (Math.PI/180)*end.latitude;

        double lon1 = (Math.PI/180)*start.longitude;
        double lon2 = (Math.PI/180)*end.longitude;

        //地球半径
        double R = 6371;

        //两点间距离 km，如果想要米的话，结果*1000就可以了
        double d =  Math.acos(Math.sin(lat1)*Math.sin(lat2)+Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon2-lon1))*R;

        return d*1000;
    }

}