package com.example.makanapa;

import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FoodListAdapter extends BaseAdapter {
    protected List<Food> listItem;
    private Presenter presenter;
    private Context context;
    private InfoFragment infoFragment;
    private AdapterView.OnItemClickListener onItemClickListener;

    public FoodListAdapter (FoodListener foodListener, Presenter presenter, Context context){
        this.presenter = presenter;
        this.context = context;
        this.listItem = new LinkedList<>();
        this.listItem.addAll(Arrays.asList(Menu.foodObjectArr));
    }

    public void addLine(Food food){
        this.listItem.add(food);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Food curFood = (Food)this.getItem(position);
        ViewHolder vh;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_item, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }
        else{
            vh = (ViewHolder)convertView.getTag();
        }

        vh.updateView(curFood,position);

        final View view = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(null, view, position, -1);
                }
            }
        });
        return convertView;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void randomFood(){
        Collections.shuffle(this.listItem);
    }

    private class ViewHolder implements View.OnClickListener{
        protected TextView menuTitle;
        protected ImageButton delete;
        protected ListView lv;
        protected int posisi;

        public ViewHolder(View view){
            this.menuTitle = view.findViewById(R.id.menu_title);
            this.delete = view.findViewById(R.id.btn_delete);

            this.delete.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        public void updateView (Food food, int posisi){
//            System.out.println(food);
            this.menuTitle.setText(food.getTitle());
            this.posisi = posisi;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == this.delete.getId()){
                listItem.remove(this.posisi);
            }
            notifyDataSetChanged();
        }
    }
}
