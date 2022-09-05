package vn.minhgiang.list.ListView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.minhgiang.list.R;

public class CustomListAdapter extends BaseAdapter {
    private List<City> cities;
    private Activity activity;

    public CustomListAdapter(List<City> cities, Activity activity) {
        this.cities = cities;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        if (cities != null) {
            return cities.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.layout_custom_listview, null, false);
        TextView namecity=convertView.findViewById(R.id.nameCity);
        ImageView imgCity=convertView.findViewById(R.id.imgCity);
        City citiesview=cities.get(position);
        namecity.setText(citiesview.getNameCity());
        imgCity.setImageResource(citiesview.getImgCity());
        return convertView;
    }

}

