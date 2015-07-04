package com.gugalor.citylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/7/3.
 */
public class home extends Activity{
    TextView location_text;

    @Override
    public void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        location_text=(TextView)findViewById(R.id.home_location_text);
        location_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, CityList.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null)
            switch (resultCode) {
                case 2:
                    location_text.setText(data.getStringExtra("city"));
                    break;

                default:
                    break;
            }
    }
}
