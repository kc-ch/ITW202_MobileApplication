package edu.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    RecyclerView mRecyclerView;
    WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<20; i++){
            mWordList.addLast("Word" + i);
        }

        mRecyclerView = findViewById(R.id.recycle);
        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager obj = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(obj);


        FloatingActionButton add = findViewById(R.id.floatingAction);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordSize = mWordList.size();
                mWordList.addLast("Word "+wordSize);
                mRecyclerView.getAdapter().notifyItemInserted(wordSize);
                mRecyclerView.smoothScrollToPosition(wordSize);
            }
        });
    }
}