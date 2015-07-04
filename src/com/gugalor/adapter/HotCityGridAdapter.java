package com.gugalor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gugalor.citylist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/6/29.
 */

public final class HotCityGridAdapter extends BaseAdapter
{
    private List<String> list = new ArrayList();
    private Context context;

    public HotCityGridAdapter(Context paramContext, List<String> paramList)
    {
        this.list = paramList;
        this.context = paramContext;
    }

    public final int getCount()
    {
        return this.list.size();
    }

    public final Object getItem(int paramInt)
    {
        return this.list.get(paramInt);
    }

    public final long getItemId(int paramInt)
    {
        return paramInt;
    }

    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        MyHolder myHolder = null;
        if (paramView == null) {
            myHolder = new MyHolder();
            paramView = ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.city_hot_item_layout, null);
            paramView.setTag(myHolder);
            myHolder.textView = (TextView) paramView.findViewById(R.id.city_hot_text);
        } else {
            myHolder = (MyHolder) paramView.getTag();
        }
        myHolder.textView.setText(list.get(paramInt));
        return paramView;
    }

    private final class MyHolder {
        TextView textView;
    }
}
