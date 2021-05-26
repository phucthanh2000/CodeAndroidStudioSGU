package com.example.money;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] items;
    private int layout;

    public CustomAdapter(Context context, int layout, String[] items) {
        super(context, layout, items);
        this.context = context;
        this.items = items;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(layout, null);
        String[] arrcurr = items[position].split(";");
        String[] arrFrom = arrcurr[0].split(":");
        String[] arrTo = arrcurr[1].split(":");
        return v;
    }
}

