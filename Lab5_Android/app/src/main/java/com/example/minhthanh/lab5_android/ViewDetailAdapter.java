package com.example.minhthanh.lab5_android;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by minh thanh on 4/5/2018.
 */

public class ViewDetailAdapter extends BaseAdapter {

    public Context mContext;
    public List<ViewDetail> mList;

    public ViewDetailAdapter(Context mContext, List<ViewDetail> mList)
    {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(mContext,R.layout.activity_main_listview,null);
        TextView textName = view.findViewById(R.id.text1);
        TextView textDate = view.findViewById(R.id.text3);
        TextView textLevel = view.findViewById(R.id.text2);
        textName.setText(mList.get(position).getName());
        textDate.setText(mList.get(position).getDate());
        if(mList.get(position).getLevel().equals("HIGH")) {
            textLevel.setText(mList.get(position).getLevel());
            textLevel.setTextColor(Color.RED);
        }
        else if (mList.get(position).getLevel().equals("NORMAL")) {
            textLevel.setText(mList.get(position).getLevel());
            textLevel.setTextColor(Color.YELLOW);
        }
        else {
            textLevel.setText(mList.get(position).getLevel());
            textLevel.setTextColor(Color.GREEN);
        }

        return view;
    }
}
