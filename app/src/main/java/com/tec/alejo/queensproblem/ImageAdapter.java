package com.tec.alejo.queensproblem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private int[] images = new int[64];
    Context context;

    public ImageAdapter (int[][] values, Context parent){

        context = parent;

        int row = 0;
        int col = 0;

        for(int pos=0; pos < 64; pos++){

            if((pos/8)%2 == 0){

                if(pos%2 == 0) images[pos] = R.drawable.white_square; else images[pos] = R.drawable.full_black_square_md;

            }else{

                if(pos%2 == 0) images[pos] = R.drawable.full_black_square_md; else images[pos] = R.drawable.white_square;
            }

            if(values[col][row] == 1) images[pos] = R.drawable.chess_piece_queen;

            row++;

            if(row > 7) {
                row = 0;
                col++;
            }

        }
    }

    @Override
    public int getCount() {
        return 64;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(150,150));
        return imageView;
    }
}
