package edu.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<Sport> mSportData;
    private SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecycleView = findViewById(R.id.recycleview);

        mRecycleView.setLayoutManager(new GridLayoutManager(this,gridColumnCount));

        mSportData = new ArrayList<>();

        mAdapter = new SportAdapter(mSportData,this);
        mRecycleView.setAdapter(mAdapter);

        initializationData();
    }
    private void initializationData(){
        TypedArray sportImageResources = getResources().obtainTypedArray(R.array.sport_image);
        String[] sportsList = getResources().getStringArray(R.array.sport_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportData.clear();

        for (int i=0; i<sportsList.length; i++){
            mSportData.add(new Sport(sportsList[i], sportsInfo[i], sportImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
        sportImageResources.recycle();
    }
}