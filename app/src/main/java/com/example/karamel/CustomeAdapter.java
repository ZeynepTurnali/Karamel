package com.example.karamel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ImageModel> imageModelArrayList;


    public CustomeAdapter(Context context, ArrayList<ImageModel> imageModelArrayList) {
        this.context = context;
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getCount() {
        return imageModelArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return imageModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_listview, null, true);

            holder.eventName = (TextView) convertView.findViewById(R.id.textView);
            holder.imageList = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.eventName.setText(imageModelArrayList.get(position).getName());
        holder.imageList.setImageResource(imageModelArrayList.get(position).getImage_drawable_list());

        return convertView;
    }

    private class ViewHolder {
        protected TextView eventName;
        private ImageView imageList;
    }
}
