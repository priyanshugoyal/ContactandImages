package com.example.priyanshu.assignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Priyanshu on 20-May-17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context context)
    {
mContext=context;
    }

    @Override
    public int getCount() {
        return imagearray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        Picasso.with(mContext)
                .load(imagearray[position])
                .resize(200, 200)
                .centerCrop()
                .into(imageView);
        return imageView;
    }
    public  Integer[] imagearray={
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,
            R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,
            R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12,
            R.drawable.image13,R.drawable.image14,R.drawable.image15,R.drawable.image16,
            R.drawable.image17,R.drawable.image18,R.drawable.image19,R.drawable.image20

    };
}
