package com.bawei.myokhttp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.myokhttp.adapter.MyBaseAdapter;
import com.bawei.myokhttp.data.Data;
import com.bawei.myokhttp.uilts.NetDataCallBack;
import com.bawei.myokhttp.uilts.OKutils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetDataCallBack<Data>{
    private ListView lv;
    private List<Data.NewsBean> list = new ArrayList<>();
    private MyBaseAdapter adapter;
    private ImageView iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv2= (ImageView) findViewById(R.id.iv2);
        lv= (ListView) findViewById(R.id.lv);
        setmaindata();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        iv2.setImageDrawable(new Circle(bitmap));


    }

    private void setmaindata() {
        String url = "http://139.196.140.118:8080/get/%7B%22%5B%5D%22:%7B%22page%22:0,%22count%22:10,%22Moment%22:%7B%22content$%22:%22%2525a%2525%22%7D,%22User%22:%7B%22id@%22:%22%252FMoment%252FuserId%22,%22@column%22:%22id,name,head%22%7D,%22Comment%5B%5D%22:%7B%22count%22:2,%22Comment%22:%7B%22momentId@%22:%22%5B%5D%252FMoment%252Fid%22%7D%7D%7D%7D";
        //实例化OKUtils
        OKutils oKutils = new OKutils();
        oKutils.getdata(url, this, Data.class);
    }

    @Override
    public void success(Data data) {
        list.addAll(data.getNews());
        adapter=new MyBaseAdapter(this,list);
        lv.setAdapter(adapter);
    }

    @Override
    public void field(int position, String str) {

    }
}
