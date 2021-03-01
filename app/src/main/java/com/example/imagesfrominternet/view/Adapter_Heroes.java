package com.example.imagesfrominternet.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagesfrominternet.R;
import com.example.imagesfrominternet.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Heroes extends RecyclerView.Adapter<Adapter_Heroes.ViewHolder> {
    ArrayList<Hero> heroArrayList;
    private Context context;
    private LayoutInflater inflater;
    public Adapter_Heroes(Context context,ArrayList<Hero> heroArrayList){
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.heroArrayList=heroArrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.model_heroes,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Heroes.ViewHolder holder, int position) {
        Hero hero=heroArrayList.get(position);
        Picasso.get().load(hero.getImageurl()).into(holder.image_hero);
        holder.name_hero.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image_hero;
        public TextView name_hero;
        public ViewHolder(View itemView){
            super(itemView);
            image_hero = (ImageView) itemView.findViewById(R.id.image_hero);
            image_hero.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            name_hero = (TextView) itemView.findViewById(R.id.name_hero);
        }
    }
}
