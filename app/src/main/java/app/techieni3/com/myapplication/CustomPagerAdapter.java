package app.techieni3.com.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by CHAITANYA-PC on 01/02/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    Context context;
    int[] images;

    public CustomPagerAdapter(Context context, int[] images) {

        this.context = context;
        this.images = images;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.viewpage, container, false);


        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        imageView.setImageResource(images[position]);

        container.addView(itemView);

        return itemView;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}