package com.ravisharma.topnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pi Last LAB on 5/2/2018.
 */

public class NewsAdapter extends ArrayAdapter {

    List<NewsModel> modelList = new ArrayList<>();
    Context context;
    int resource;
    LayoutInflater inflater;

    public NewsAdapter( Context context, int resource, List<NewsModel> object) {
        super(context, resource, object);
        this.context=context;
        this.resource=resource;
        this.modelList=object;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(resource,null);
            holder = new ViewHolder();

            holder.title = (TextView)convertView.findViewById(R.id.text_newstitle);
            holder.description = (TextView)convertView.findViewById(R.id.text_description);
            holder.imageurl = (ImageView) convertView.findViewById(R.id.imageView);
            holder.layout = (LinearLayout)convertView.findViewById(R.id.link_layout);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        final NewsModel model = modelList.get(position);

        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        Picasso.with(context).load(model.getImage()).into(holder.imageurl);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("data",model.getUrl());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    public static class ViewHolder{
        ImageView imageurl;
        LinearLayout layout;
        TextView title, description;
    }
}
