package com.bawei.myokhttp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myokhttp.R;
import com.bawei.myokhttp.data.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 * 1506A
 * 郝健澄
 */

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Data.NewsBean> list = new ArrayList<>();


    public MyBaseAdapter(Context context,List<Data.NewsBean> list) {
        this.context = context;
        this.list = list;



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViweHolder holder=null;
        if (convertView==null){
            holder=new ViweHolder();
            convertView=View.inflate(context, R.layout.ieme,null);
            holder.tv1= (TextView) convertView.findViewById(R.id.tv1);
            holder.iv1= (ImageView) convertView.findViewById(R.id.iv1);
            convertView.setTag(holder);
        }else {
            holder= (ViweHolder) convertView.getTag();
        }
        holder.tv1.setText(list.get(position).getUser().getName());


//        imageLoader.displayImage("http://img4.imgtn.bdimg.com/it/u=3028702483,4182396631&fm=27&gp=0.jpg",holder.iv1);
        //Glide.with(context).load(list.get(position).getComment().get(position).).into(holder.iv1);

        return convertView;
    }
   public class ViweHolder{
        TextView tv1;
       ImageView iv1;
    }
}
