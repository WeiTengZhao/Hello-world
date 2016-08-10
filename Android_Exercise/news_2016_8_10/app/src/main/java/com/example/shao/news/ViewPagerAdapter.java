package com.example.shao.news;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Shao on 2016/8/3.
 */
public class ViewPagerAdapter extends PagerAdapter{
    List<View> mviewlist = null;

    public ViewPagerAdapter(List<View> mviewlist) {
        this.mviewlist = mviewlist;
    }

    @Override
    public int getCount() {
        return mviewlist.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(mviewlist.get(position));
        return mviewlist.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(mviewlist.get(position));
//        super.destroyItem(container, position, object);
    }
}
