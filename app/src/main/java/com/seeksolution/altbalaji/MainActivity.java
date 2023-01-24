package com.seeksolution.altbalaji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;


import com.seeksolution.altbalaji.Adapters.LatestAdapters;
import com.seeksolution.altbalaji.Adapters.TrendingAdapters;
import com.seeksolution.altbalaji.Adapters.TvAdapters;
import com.seeksolution.altbalaji.models.LatestModel;
import com.seeksolution.altbalaji.models.TrendingModel;
import com.seeksolution.altbalaji.models.TvModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Trending list
    private RecyclerView recyclerView;
    private String[] ImageUrls = {
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1208/1431208-v-895cd0d6b37f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
    };
    ArrayList<TrendingModel> modelArrayList;
    //Latest list
    private RecyclerView recyclerView_1;
    private String[] ImageUrls_1 ={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1208/1431208-v-895cd0d6b37f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
    };
    ArrayList<LatestModel> modelArrayList1;

    private RecyclerView recyclerView_2;
    private String[] ImageUrls_2={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1208/1431208-v-895cd0d6b37f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",

    };
    ArrayList<TvModel> modelArrayList2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rc_view_trending_list);
        recyclerView_1 =(RecyclerView) findViewById(R.id.rc_view_latest_list);
        recyclerView_2 =(RecyclerView) findViewById(R.id.rc_view_tv_list);

//     Layout manager => Horizontol
        modelArrayList= new ArrayList<TrendingModel>();
        for (int i = 0; i < ImageUrls.length; i++) {
           modelArrayList.add(new TrendingModel(ImageUrls[i]));
        }
        TrendingAdapters adapters = new TrendingAdapters(getApplicationContext(),modelArrayList);
        //This is Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapters);
//        ArrayAdapter<TrendingModel> arrayAdapter = new ArrayAdapter<TrendingModel>(getApplicationContext(),arrayList);
//        //set Adapter
//        recyclerView.setAdapter(arrayAdapter);
        modelArrayList1= new ArrayList<LatestModel>();
        for (int i = 0; i<ImageUrls_1.length;i++){
            modelArrayList1.add( new LatestModel(ImageUrls_1[i]));
        }
        LatestAdapters adapters1 = new LatestAdapters(getApplicationContext(),modelArrayList1);
        recyclerView_1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_1.setAdapter(adapters1);


        modelArrayList2= new ArrayList<TvModel>();
        for (int i=0; i<ImageUrls_2.length; i++){
            modelArrayList2.add(new TvModel(ImageUrls_2[i]));
        }
       TvAdapters adapters2 = new TvAdapters(getApplicationContext(),modelArrayList2);
        recyclerView_2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView_2.setAdapter(adapters2);

    }
}
