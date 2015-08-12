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
public class CitysearchNonAdapter extends BaseAdapter {
    private Context mContext;

    public CitysearchNonAdapter(Context context) {
        mContext = context;
    }

    public void refresh(List<Contacts> list) {
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.empty_search_city_item, null);

        return convertView;
    }

    class Holder {
        private TextView mNameText, mIDText;
    }
}