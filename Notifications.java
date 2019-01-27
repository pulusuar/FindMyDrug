package com.avinash.findmydrug;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Notifications extends AppCompatActivity {

    ListView noti;
    Cursor c;
    MySQLiteNotificationData db;
    NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        db = new MySQLiteNotificationData(this);
        db.open();

        noti = (ListView) findViewById(R.id.listView1);
        updateList();

        db.close();

    }

    void updateList(){
        c = db.viewNotifications();
        adapter = new NotificationAdapter(this);
        noti.setAdapter(adapter);
    }
    class NotificationAdapter extends BaseAdapter
    {
        Context context;
        public NotificationAdapter(Context c)
        {
            this.context=c;
        }

        @Override
        public int getCount() {
            return c.getCount();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            convertView =inflater.inflate(R.layout.notification_list_view,null);

            TextView t1=(TextView) convertView.findViewById(R.id.message);

            c.moveToPosition(position);

            t1.setText(c.getString(1));

            return convertView;

        }
    }
}
