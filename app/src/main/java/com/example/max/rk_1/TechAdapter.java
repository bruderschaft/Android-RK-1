package com.example.max.rk_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.max.rk_1.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by max on 05.04.15.
 */
public class TechAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Technology> objects;

    TechAdapter(Context context, ArrayList<Technology> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }

        Technology t = getTechnology(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.techTitle)).setText(t.title);
        if (t.info != null){
            ((TextView) view.findViewById(R.id.techInfo)).setText(t.info);
        }
        Picasso.with(ctx).load("http://mobevo.ext.terrhq.ru/" + t.picture)
                .resize(64,64)
                .into(((ImageView) view.findViewById(R.id.techImage)));

        return view;
    }

    // товар по позиции
    Technology getTechnology(int position) {
        return ((Technology) getItem(position));
    }

}
