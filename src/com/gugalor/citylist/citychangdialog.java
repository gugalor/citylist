package com.gugalor.citylist;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gugalor on 2015/6/12.
 */
public class citychangdialog extends Dialog {
    private Button city_change_again, city_change_cancel;
    private TextView changmsg;
    private Context context;
    private String cityName;
    private ClickListenerInterface clickListenerInterface;

    public citychangdialog(Context context, String string) {
        super(context, R.style.MyDialog);
        this.context = context;
        this.cityName=string;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(context).inflate(R.layout.city_change_dailog, null);
        setContentView(view);
        city_change_again = (Button) view.findViewById(R.id.city_change_again);
        city_change_cancel = (Button) view.findViewById(R.id.city_change_cancel);
        changmsg = (TextView) view.findViewById(R.id.city_change_msg);
        changmsg.setText(context.getString(R.string.locatez_as)+cityName+context.getString(R.string.switch_ornot));
        city_change_again.setOnClickListener(new clickListener());
        city_change_cancel.setOnClickListener(new clickListener());
    }

    public interface ClickListenerInterface {

        public void doConfirm();

        public void doCancel();
    }

    public void setClicklistener(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }

    private class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.city_change_again:
                    clickListenerInterface.doConfirm();
                    break;
                case R.id.city_change_cancel:
                    clickListenerInterface.doCancel();
                    break;
            }
        }
    }
}