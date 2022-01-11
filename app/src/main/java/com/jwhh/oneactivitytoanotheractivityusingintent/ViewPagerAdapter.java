package com.jwhh.oneactivitytoanotheractivityusingintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<Integer> imageListids;
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(ArrayList<Integer> imageListids, Context context){
        this.imageListids=imageListids;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return imageListids.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LinearLayout linearLayout=(LinearLayout) this.layoutInflater.inflate(R.layout.pager_item,container,false);
        ImageView imageView=linearLayout.findViewById(R.id.display_image);

        imageView.setImageResource(this.imageListids.get(position));

        container.addView(linearLayout);

        return linearLayout;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
