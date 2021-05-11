package edu.gcit.todo_16;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItem = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItem, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView wordItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(@NonNull View itemView, WordListAdapter mAdapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String ele = mWordList.get(mPosition);
            mWordList.set(mPosition, "Clicked" + ele);
            mAdapter.notifyDataSetChanged();
        }
    }

}
