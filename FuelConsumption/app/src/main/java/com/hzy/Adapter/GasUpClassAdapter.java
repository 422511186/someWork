package com.hzy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hzy.Entity.GasUpClass;
import com.hzy.R;

import java.util.List;

public class GasUpClassAdapter extends ArrayAdapter<GasUpClass> {

    private Context mContext;
    public GasUpClassAdapter(@NonNull Context context, int resource, @NonNull List<GasUpClass> objects) {
        super(context, resource, objects);
        mContext=context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GasUpClass item = getItem(position);
        View view = LayoutInflater.from(mContext).inflate(R.layout.items,parent,false);
        TextView Average_fuel_consumption = (TextView) view.findViewById(R.id.Average_fuel_consumption);
        TextView date = (TextView) view.findViewById(R.id.date);
        Average_fuel_consumption.setText("油耗 : "+String.valueOf(item.getAverage_fuel_consumption()+"r/km"));
        date.setText(String.valueOf(item.getDate()));
        return view;
    }
}
