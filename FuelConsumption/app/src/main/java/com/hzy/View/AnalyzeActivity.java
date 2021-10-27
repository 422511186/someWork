package com.hzy.View;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hzy.Adapter.GasUpClassAdapter;
import com.hzy.Entity.GasUpClass;
import com.hzy.R;
import com.hzy.SQL.MydatabaseHelper;

import java.util.ArrayList;

public class AnalyzeActivity extends AppCompatActivity {
    private MydatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        db = new MydatabaseHelper(this,"GasUpClass.db",null,1);
        SQLiteDatabase readableDatabase = db.getWritableDatabase();
        ArrayList<GasUpClass> list = new ArrayList<>();
        Cursor cursor = readableDatabase.query("GasUpClass", null, null, null, null,
                null, null);
        if(cursor.getCount() > 0)
        {
            //移动到首位
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int average_fuel_consumption1 = cursor.getColumnIndex("Average_fuel_consumption");
                double average_fuel_consumption = cursor.getInt(average_fuel_consumption1);
                int date1 = cursor.getColumnIndex("Date");
                String date = cursor.getString(date1);

                GasUpClass gas = new GasUpClass();
                gas.setAverage_fuel_consumption(average_fuel_consumption);
                gas.setDate(date);
                list.add(gas);
                //移动到下一位
                cursor.moveToNext();
            }
        }

        cursor.close();
        readableDatabase.close();


        GasUpClassAdapter gasUpClassAdapter = new GasUpClassAdapter(AnalyzeActivity.this,
                android.R.layout.simple_list_item_1,list);

        ListView listView =(ListView) findViewById(R.id.list_view);
        listView.setAdapter(gasUpClassAdapter);
    }
}