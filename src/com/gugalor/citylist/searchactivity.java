package com.gugalor.citylist;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by gugalor
 */
public class searchactivity extends Activity {
    ListView searchresult;
    private EditText input;
    private ImageButton clear;
    private TextView right;
    Boolean isEmpty = true;
    //  ArrayAdapter<String> adapter;
    private SQLiteDatabase database;
    private ArrayList<CityModel> mCityNames=new ArrayList<CityModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlayout);
        searchresult = (ListView) findViewById(R.id.searchresult);
        input = (EditText) findViewById(R.id.input);
        clear = (ImageButton) findViewById(R.id.clear);
        right = (TextView) findViewById(R.id.right);
        database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
            }
        });
        final CitysearchAdapter adapter = new CitysearchAdapter(mCityNames, this);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(right.getText().equals("取消"))
                    finish();
                else{
                String NAMA=input.getText().toString();
                if(NAMA.equals(""))
                    input.setHint("请输入关键字");
                else
                mCityNames = getCityNames(NAMA);
                if(mCityNames.isEmpty())
                Toast.makeText(searchactivity.this, "抱歉，未找到！", Toast.LENGTH_SHORT).show();
                else
                adapter.refresh(mCityNames);
                }
            }
        });


        //adapter = new ArrayAdapter<String>(this, R.layout.bookname_list, mCityNames);
        searchresult.setAdapter(adapter);
        searchresult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final CityModel cityModel = (CityModel)mCityNames.get(position);
    			Setting.Save2SharedPreferences(searchactivity.this, "city",
    					cityModel.getCityName());
                Intent intent =new Intent();
                intent.putExtra("city",cityModel.getCityName());
                setResult(RESULT_OK,intent);
    			finish();

            }
        });

        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                clear.setVisibility(View.INVISIBLE);
                right.setText("搜索");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
//                input.setText(s);
            }

        });


    }
    /**
     * 从数据库获取城市数据
     *
     * @return
     */
    private ArrayList<CityModel> getCityNames(String string)
    {
        ArrayList<CityModel> names = new ArrayList<CityModel>();
        Cursor cursor = database.rawQuery("SELECT CityName FROM T_City where CityName like '%"+string+"%' ORDER BY NameSort", null);
        for (int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            CityModel cityModel = new CityModel();
            cityModel.setCityName(cursor.getString(cursor.getColumnIndex("CityName")));
            names.add(cityModel);
        }
        return names;
    }


}
