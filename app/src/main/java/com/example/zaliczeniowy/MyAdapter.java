package com.example.zaliczeniowy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    public int [] pcty;
    public String [] opsiy;

    public MyAdapter(Context context, int[] pcty, String[] opsiy) {
        super(context,R.layout.my_spinner_items);
        this.context = context;
        this.pcty = pcty;
        this.opsiy = opsiy;

    }

    @Override
    public int getCount() {
        return pcty.length;
    }

    @Override
    public String getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.my_spinner_items, null);
            TextView t1 = (TextView) row.findViewById(R.id.textView);
            ImageView i1 = (ImageView) row.findViewById(R.id.imageView);

            t1.setText(opsiy[position]);
            i1.setImageResource(pcty[position]);

            TextView t2 = (TextView) row.findViewById(R.id.textView);
            ImageView i2 = (ImageView) row.findViewById(R.id.imageView);

            t2.setText(opsiy[position]);
            i2.setImageResource(pcty[position]);
            TextView t3 = (TextView) row.findViewById(R.id.textView);
            ImageView i3 = (ImageView) row.findViewById(R.id.imageView);

            t3.setText(opsiy[position]);
            i3.setImageResource(pcty[position]);

            TextView t4 = (TextView) row.findViewById(R.id.textView);
            ImageView i4 = (ImageView) row.findViewById(R.id.imageView);

            t4.setText(opsiy[position]);
            i4.setImageResource(pcty[position]);


            return row;
        }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.my_spinner_items, null);
            TextView t1 = (TextView) row.findViewById(R.id.textView);
            ImageView i1 = (ImageView) row.findViewById(R.id.imageView);

            t1.setText(opsiy[position]);
            i1.setImageResource(pcty[position]);

            TextView t2 = (TextView) row.findViewById(R.id.textView);
            ImageView i2 = (ImageView) row.findViewById(R.id.imageView);

            t2.setText(opsiy[position]);
            i2.setImageResource(pcty[position]);

            TextView t3 = (TextView) row.findViewById(R.id.textView);
            ImageView i3 = (ImageView) row.findViewById(R.id.imageView);

            t3.setText(opsiy[position]);
            i3.setImageResource(pcty[position]);

            TextView t4 = (TextView) row.findViewById(R.id.textView);
            ImageView i4 = (ImageView) row.findViewById(R.id.imageView);

            t4.setText(opsiy[position]);
            i4.setImageResource(pcty[position]);
        return row;
    }

}
