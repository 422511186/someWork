package com.hzy.View;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hzy.Entity.GasUpClass;
import com.hzy.R;
import com.hzy.SQL.MydatabaseHelper;

public class InsertActivity extends AppCompatActivity {

    private MydatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = new MydatabaseHelper(this,"GasUpClass.db",null,1);

        EditText priceInput = (EditText)findViewById(R.id.priceInput);
        EditText unitPriceInput = (EditText)findViewById(R.id.unitPriceInput);
        EditText mileageInput = (EditText)findViewById(R.id.mileageInput);
        Button reset = (Button) findViewById(R.id.reset);
        Button save = (Button) findViewById(R.id.save);


        /**
         * 重置输入框内容
         */
        reset.setOnClickListener(e->{
            priceInput.setText("");
            unitPriceInput.setText("");
            mileageInput.setText("");
        });

        /**
         * 保存数据到持久层
         */
        save.setOnClickListener(e->{
            SQLiteDatabase writableDatabase = db.getWritableDatabase();

            GasUpClass gasUpClass = new GasUpClass(
                    Double.parseDouble(priceInput.getText().toString()),
                    Double.parseDouble(unitPriceInput.getText().toString()),
                    Double.parseDouble(mileageInput.getText().toString())
            );


            ContentValues values = new ContentValues();
            values.put("price",String.valueOf(gasUpClass.getPrice()));
            values.put("unitPrice",String.valueOf(gasUpClass.getUnitPrice()));
            values.put("mileage",String.valueOf(gasUpClass.getMileage()));
            values.put("Average_fuel_consumption",String.valueOf(gasUpClass.getAverage_fuel_consumption()));
            values.put("Date",gasUpClass.getDate());
            writableDatabase.insert("GasUpClass",null,values);
        });


    }
}