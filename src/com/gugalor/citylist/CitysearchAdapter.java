package com.gugalor.citylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gugalor.model.Contacts;

import java.util.List;

/**
 * Created by gugalor on 14-5-31.
 */
public class CitysearchAdapter extends BaseAdapter {
    private List<Contacts> mList;
    private Context mContext;

    public CitysearchAdapter(List<Contacts> list, Context context) {
        mList = list;
        mContext = context;
    }

    public void refresh(List<Contacts> list) {
        mList = list;
        notifyDataSetChanged();
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
        Holder holder = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.city_search_list_item, null);
                holder = new Holder();
                holder.mNameText = (TextView) convertView.findViewById(R.id.area);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            final Contacts cityModel = (Contacts) mList.get(position);
            holder.mNameText.setText(cityModel.getName());
        return convertView;
    }

    class Holder {
        private TextView mNameText, mIDText;
    }
}