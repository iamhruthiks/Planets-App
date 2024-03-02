package com.example.planets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetArrayList;
    private Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context,R.layout.my_planets,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        Planet planet=getItem(position);
        ViewHolder holder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.my_planets,parent,false);
            holder=new ViewHolder();
            holder.planetName=convertView.findViewById(R.id.textView1);
            holder.moonCount=convertView.findViewById(R.id.textView2);
            holder.planetImage=convertView.findViewById(R.id.imageView1);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }

        holder.planetName.setText(planet.getPlanetName());
        holder.moonCount.setText(planet.getMoonCount());
        holder.planetImage.setImageResource(planet.getPlanetImage());

        return  convertView;
    }

    static class ViewHolder{
        ImageView planetImage;
        TextView planetName,moonCount;
    }
}
