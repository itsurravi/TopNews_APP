package com.ravisharma.topnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends ArrayAdapter {

    String[] name;
    String[] slogan;
    Integer[] image;
    Context context;
    LayoutInflater inflater;

    public ListAdapter(Context context, String[] name, String[] slogan, Integer[] image) {
        super(context, R.layout.list_main_custom, name);
        this.context = context;
        this.name = name;
        this.slogan = slogan;
        this.image = image;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_main_custom, parent, false);

        TextView n = (TextView) view.findViewById(R.id.text_heading);
        TextView s = (TextView) view.findViewById(R.id.text_slogan);
        CircleImageView imageView = (CircleImageView) view.findViewById(R.id.image_main);

        n.setText(name[position]);
        s.setText(slogan[position]);
        imageView.setImageResource(image[position]);

        return view;
    }
}
