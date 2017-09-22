package com.bawei.myokhttp.uilts;

/**
 * Created by Administrator on 2017/9/21.
 * 1506A
 * 郝健澄
 */

public interface NetDataCallBack<T> {
    void success(T t);
    void field(int position,String str);

}
