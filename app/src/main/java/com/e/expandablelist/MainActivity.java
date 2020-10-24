package com.e.expandablelist;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.e.expandablelist.Database.DBHelper;
import com.e.expandablelist.adapter.ExpandableRecyclerViewAdapterImplementation;
import com.e.expandablelist.adapter.SpaceItemDecoration;
import com.e.expandablelist.model.PhonePOJO;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ExpandableRecyclerViewAdapterImplementation adapter;
    private boolean catErrorOccured = false;
    DBHelper dbHelper;

    ArrayList<PhonePOJO> iphoneDataList = new ArrayList<PhonePOJO>();
    ArrayList<PhonePOJO> samsungDataList = new ArrayList<PhonePOJO>();

    ArrayList<PhonePOJO> filterList = new ArrayList<PhonePOJO>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();



    }

    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        dbHelper = new DBHelper(this);

        setSupportActionBar(toolbar);

        // Set up toolbar

        setupPhoneDataList();
        // recycler view
        setUpRecyclerView();

        Cursor c = dbHelper.getPhonedetail();
        if(c.getCount()!=0){
            dbHelper.deletelist();
        }
    }

    private void setupPhoneDataList() {



    }

    private void setUpRecyclerView() {

        adapter = new ExpandableRecyclerViewAdapterImplementation(this);

        // Set up decorations


        // Layout manager
        LinearLayoutManager manager = new LinearLayoutManager(this);

        // Add to recycler view
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(2));
        recyclerView.setAdapter(adapter);
    }



    public void loadIPhone(){

        Drawable image = getResources().getDrawable( R.drawable.apple);

        PhonePOJO pojo = new PhonePOJO();
        pojo.setTitle("iPhone 6");
        pojo.setDate("2016-06-18");
        pojo.setRating(3.5f);
        pojo.setQuantity("10");
        pojo.setPicture(image);

        adapter.iphoneList.add(pojo);
        iphoneDataList.add(pojo);


        PhonePOJO pojo1 = new PhonePOJO();
        pojo1.setTitle("iPhone 6s");
        pojo1.setDate("2016-06-18");
        pojo1.setRating(3.00f);
        pojo1.setQuantity("13");
        pojo1.setPicture(image);
        adapter.iphoneList.add(pojo1);
        iphoneDataList.add(pojo1);

        PhonePOJO pojo2 = new PhonePOJO();
        pojo2.setTitle("iPhone 7");
        pojo2.setDate("2017-06-18");
        pojo2.setRating(3.0f);
        pojo2.setQuantity("16");
        pojo2.setPicture(image);
        adapter.iphoneList.add(pojo2);
        iphoneDataList.add(pojo2);

        PhonePOJO pojo3 = new PhonePOJO();
        pojo3.setTitle("iPhone 8");
        pojo3.setDate("2018-06-18");
        pojo3.setRating(3.5f);
        pojo3.setQuantity("14");
        pojo3.setPicture(image);
        adapter.iphoneList.add(pojo3);
        iphoneDataList.add(pojo3);

        PhonePOJO pojo4 = new PhonePOJO();
        pojo4.setTitle("iPhone X");
        pojo4.setDate("2019-06-18");
        pojo4.setRating(4.0f);
        pojo4.setQuantity("15");
        pojo4.setPicture(image);
        adapter.iphoneList.add(pojo4);
        iphoneDataList.add(pojo4);

        PhonePOJO pojox = new PhonePOJO();
        pojox.setTitle("iPhone XR");
        pojox.setDate("2019-06-18");
        pojox.setRating(4.0f);
        pojox.setQuantity("17");
        pojox.setPicture(image);
        adapter.iphoneList.add(pojox);
        iphoneDataList.add(pojox);


        for(int i=0;i<iphoneDataList.size();i++){

            PhonePOJO phonePOJO = iphoneDataList.get(i);

            dbHelper.add_phone(i+"",phonePOJO.getTitle(),phonePOJO.getRating()+"",phonePOJO.getDate(),phonePOJO.getQuantity(),"iphone","");

        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setExpansionStateExpanded(0);
            }
        }, 1000);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void loadSamsung(){


        Drawable image = getResources().getDrawable( R.drawable.samsung);
        PhonePOJO pojo = new PhonePOJO();
        pojo.setTitle("Samsung S7");
        pojo.setDate("2015-06-18");
        pojo.setRating(3.5f);
        pojo.setQuantity("14");
        pojo.setPicture(image);
        adapter.samsungList.add(pojo);
        samsungDataList.add(pojo);

        PhonePOJO pojo1 = new PhonePOJO();
        pojo1.setTitle("Samsung S8");
        pojo1.setDate("2016-06-18");
        pojo1.setRating(3.0f);
        pojo1.setQuantity("13");
        pojo1.setPicture(image);
        adapter.samsungList.add(pojo1);
        samsungDataList.add(pojo1);

        PhonePOJO pojo2 = new PhonePOJO();
        pojo2.setTitle("Samsung S9");
        pojo2.setDate("2017-06-18");
        pojo2.setRating(3.0f);
        pojo2.setQuantity("16");
        pojo2.setPicture(image);
        adapter.samsungList.add(pojo2);
        samsungDataList.add(pojo2);

        PhonePOJO pojo3 = new PhonePOJO();
        pojo3.setTitle("Samsung S10");
        pojo3.setDate("2018-06-18");
        pojo3.setRating(3.5f);
        pojo3.setQuantity("14");
        pojo3.setPicture(image);
        adapter.samsungList.add(pojo3);
        samsungDataList.add(pojo3);

        PhonePOJO pojo4 = new PhonePOJO();
        pojo4.setTitle("Note 7");
        pojo4.setDate("2019-06-18");
        pojo4.setRating(4.0f);
        pojo4.setQuantity("15");
        pojo4.setPicture(image);
        adapter.samsungList.add(pojo4);
        samsungDataList.add(pojo4);

        PhonePOJO pojox = new PhonePOJO();
        pojox.setTitle("Note 8");
        pojox.setDate("2019-06-18");
        pojox.setRating(4.0f);
        pojox.setQuantity("17");
        pojox.setPicture(image);
        adapter.samsungList.add(pojox);
        samsungDataList.add(pojox);

        PhonePOJO pojoxn = new PhonePOJO();
        pojoxn.setTitle("Note 9");
        pojoxn.setDate("2019-06-18");
        pojoxn.setRating(4.0f);
        pojoxn.setQuantity("17");
        pojoxn.setPicture(image);
        adapter.samsungList.add(pojoxn);
        samsungDataList.add(pojoxn);

        PhonePOJO pojoxx = new PhonePOJO();
        pojoxx.setTitle("Note 10");
        pojoxx.setDate("2019-06-18");
        pojoxx.setRating(4.0f);
        pojoxx.setQuantity("17");
        pojoxx.setPicture(image);
        adapter.samsungList.add(pojoxx);
        samsungDataList.add(pojoxx);


        for(int i=0;i<samsungDataList.size();i++){

            PhonePOJO phonePOJO = samsungDataList.get(i);

            dbHelper.add_phone(i+"",phonePOJO.getTitle(),phonePOJO.getRating()+"",phonePOJO.getDate(),phonePOJO.getQuantity(),"samsung","");

        }



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setExpansionStateExpanded(1);
            }
        }, 1000);
    }


    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu,menu);

        if(menu instanceof MenuBuilder){

            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.quantity:

                Cursor c  = dbHelper.sortByQuantity();

                 filterListData(c);

                break;

            case R.id.rating:
                Cursor cRating  = dbHelper.sortByRating();

                filterListData(cRating);



                break;

            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void filterListData(Cursor c) {

        if(c.getCount()!=0) {

            filterList.clear();

            while (c.moveToNext()) {

                String id = c.getString(1);
                String feedback = c.getString(2);
                String rating = c.getString( 3);
                String date = c.getString(4);
                String qnty = c.getString(5);
                String type = c.getString(6);
                String image =c.getString(7);

                PhonePOJO dbpojo = new PhonePOJO();
                dbpojo.setTitle(feedback);
                dbpojo.setDate(date);
                dbpojo.setRating(Float.parseFloat(rating));
                dbpojo.setQuantity(qnty);
                dbpojo.setType(type);
                filterList.add(dbpojo);

            }

        }

        if(filterList!=null){

            ArrayList<PhonePOJO> samsungData = new ArrayList<>();
            ArrayList<PhonePOJO> iphoneData = new ArrayList<>();

            Drawable imageSam = getResources().getDrawable( R.drawable.samsung);

            Drawable apple = getResources().getDrawable( R.drawable.apple);

            samsungData.clear();
            iphoneData.clear();

            for(int i=0;i<filterList.size();i++){
                PhonePOJO phonePOJO = filterList.get(i);
                if(phonePOJO.getType().equalsIgnoreCase("samsung")){
                    phonePOJO.setPicture(imageSam);
                    samsungData.add(phonePOJO);
                }
                else if(phonePOJO.getType().equalsIgnoreCase("iphone")){
                    phonePOJO.setPicture(apple);
                    iphoneData.add(phonePOJO);
                }

            }

            adapter.addIPhoneData(iphoneData);

            adapter.addSumsungData(samsungData);

        }
    }
}