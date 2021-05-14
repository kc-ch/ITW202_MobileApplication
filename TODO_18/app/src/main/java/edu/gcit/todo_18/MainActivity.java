package edu.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    ArrayList mSportData;
    Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView)findViewById(R.id.recycler);
        //components of recyclerView
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mSportData = new ArrayList<>();
        mAdapter = new Adapter(mSportData, this);
        mRecycler.setAdapter(mAdapter);

        initializeData();
    }
    private void initializeData(){
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sport_images);
        String[] sportsList = getResources().getStringArray(R.array.sport_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sport_info);

        mSportData.clear();

        for (int i = 0;i<sportsInfo.length; i++){
            mSportData.add(new Sport(sportsList[i], sportsInfo[i], sportImageResources.getResourceId(i, 0)));
        }
        mAdapter.notifyDataSetChanged();
        sportImageResources.recycle();
    }
}