package com.avinash.findmydrug;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by AVINASH on 12-03-2018.
 */

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] stores;
    private final String[] address;
    private final String[] phone;
    public MyListAdapter(Activity context,String[] stores, String[] address, String[] phone){
        super(context,R.layout.list_view,stores);
        this.context = context;
        this.stores = stores;
        this.address = address;
        this.phone = phone;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_view,null, true);
        TextView shop_name = (TextView) rowView.findViewById(R.id.shopname);
        TextView shop_address = (TextView) rowView.findViewById(R.id.address);
        TextView phone_no = (TextView) rowView.findViewById(R.id.phoneNo);

        shop_name.setText(stores[position]);
        shop_address.setText(address[position]);
        phone_no.setText(phone[position]);

        return rowView;
    }
}
