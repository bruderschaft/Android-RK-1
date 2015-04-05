package com.example.max.rk_1.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashMap;

/**
 * Created by max on 02.04.15.
 */
public class MyAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    int count;
    HashMap<Integer, String> nummerToName;

    public MyAdapter(Context context, int itemsCount){
        ctx = context;
        count = itemsCount;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nummerToName.put(0, "ноль");
        nummerToName.put(1, "один");
        nummerToName.put(2, "два");
        nummerToName.put(3, "три");
        nummerToName.put(4, "четыре");
        nummerToName.put(5, "пять");
        nummerToName.put(6, "шесть");
        nummerToName.put(7, "семь");
        nummerToName.put(8, "восемь");
        nummerToName.put(9, "девять");
        nummerToName.put(10, "десять");
        nummerToName.put(11, "одиннадцать");
        nummerToName.put(12, "двенадцать");
        nummerToName.put(13, "тринадцать");
        nummerToName.put(14, "четырнацать");
        nummerToName.put(15, "пятнадцать");
        nummerToName.put(16, "шестнадцать");
        nummerToName.put(17, "семнадцать");
        nummerToName.put(18, "восемнадцать");
        nummerToName.put(19, "девятнадцать");
        nummerToName.put(20, "двадцать");
        nummerToName.put(30, "тридцать");
        nummerToName.put(40, "сорок");
        nummerToName.put(50, "пятьдесят");
        nummerToName.put(60, "шестьдесят");
        nummerToName.put(70, "семьдесят");
        nummerToName.put(80, "восемьдесят");
        nummerToName.put(90, "девяносто");
        nummerToName.put(100, "сто");
        nummerToName.put(200, "двести");
        nummerToName.put(300, "триста");
        nummerToName.put(400, "четыреста");
        nummerToName.put(500, "пятьсот");
        nummerToName.put(600, "шестьсот");
        nummerToName.put(700, "семьсот");
        nummerToName.put(800, "восемьсот");
        nummerToName.put(900, "девятьсот");
        nummerToName.put(1000, "тысяча");

    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        String text = "";
        if (position == 1000){
            text += nummerToName.get(position);
        }
        
        if (position >= 100 && position < 1000){
            text += nummerToName.get((int)position/100) + ' ';
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
