package com.example.myapplication;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Item; // Import your model class

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<com.example.myapplication.Item> itemList;

    public CustomAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView title = convertView.findViewById(R.id.textViewTitle);
        TextView description = convertView.findViewById(R.id.textViewDescription);

        Item currentItem = itemList.get(position);
        title.setText(currentItem.getTitle());
        description.setText(currentItem.getDescription());

        return convertView;
    }
}


