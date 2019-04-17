package com.example.karamel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String list[] = {"Tennis Playing", "Cat Feeding Activity", "Concert of Imagine Dragons", "Cinema Event"};
    ListView listView;
    private ArrayList<ImageModel> imageModelList;
    private CustomeAdapter customeAdapter;
    private int imageList[] = new int[]{R.drawable.tennis_icon, R.drawable.canned_food, R.drawable.performance, R.drawable.cinema};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.event_list);

        imageModelList = populateList();
        Log.d("tag", imageModelList.size() + "");
        customeAdapter = new CustomeAdapter(this, imageModelList);
        listView.setAdapter(customeAdapter);
    }

    private ArrayList<ImageModel> populateList() {
        ArrayList<ImageModel> list_array = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.setName(list[i]);
            imageModel.setImage_drawable_list(imageList[i]);
            list_array.add(imageModel);
        }
        return list_array;

    }
}
