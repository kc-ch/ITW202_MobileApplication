package edu.gcit.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {
    private ArrayList<Sport> mSportData;
    private Context mContext;

    public SportAdapter(ArrayList<Sport> mSportData, Context mContext) {
        this.mSportData = mSportData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.ViewHolder holder, int position) {
        Sport currentSport = mSportData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleText;
        private TextView mInfotext;
        private ImageView mSportImage;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.newsTitle);
            mInfotext = (TextView)itemView.findViewById(R.id.info);
            mSportImage = (ImageView)itemView.findViewById(R.id.sportimage);
        }
        void bindTo(Sport currentSport){
            mTitleText.setText(currentSport.getTitle());
            mInfotext.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportImage);
        }
    }
}
