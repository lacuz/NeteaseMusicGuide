package com.orandnot.neteasemusicguide;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class IntroduceActivity extends Activity {

    private ArrayList<View> mList = new ArrayList();
    IntroduceViewPager mViewPager ;
    private  int currentPager;
    private LinearLayout llyDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_introduce);
        mViewPager = (IntroduceViewPager)findViewById(R.id.viewPager) ;
        llyDots = (LinearLayout)findViewById(R.id.lly_dot) ;
        init();
    }

    private void init() {
        findViewById(R.id.tv_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        findViewById(R.id.tv_try).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        float bigHeight = 1F * getResources().getDisplayMetrics().heightPixels / 1920.0F;
        for(int i=0;i<3;i++) {
            IntroduceLayout localh = new IntroduceLayout(this, i);
            mList.add(localh);
//            View view  = LayoutInflater.from(this).inflate(R.layout.dot, null);
            View view  = new View(this);
            LinearLayout.LayoutParams param  = new LinearLayout.LayoutParams((int)(20*bigHeight),(int)(20*bigHeight));
            param .rightMargin = (int)(20*bigHeight);
            view.setLayoutParams(param);
            llyDots.addView(view);
        }
        mViewPager.setPageTransformer(true, new NGGuidePageTransformer());
        mViewPager.setAdapter(new mPagerAdapter());
        mViewPager.setOnPageChangeListener(new MyPageChangeListener());
        selectDots(0);
    }

    private void selectDots(int select) {
        for(int i=0;i<mList.size();i++){
            llyDots.getChildAt(i).setBackgroundResource(i==select?R.drawable.dot_sel :R.drawable.dot_nor);//dot_sel
        }
    }

    class MyPageChangeListener implements ViewPager.OnPageChangeListener
    {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            IntroduceLayout il = (IntroduceLayout) mList.get(position);
            il.start(currentPager<position?true:false);
            selectDots(position);
            currentPager = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    }


    class mPagerAdapter extends PagerAdapter
    {

        @Override
        public int getCount() {
            return mList.size();
        }


        @Override
        public boolean isViewFromObject(View paramView, Object paramObject) {
            return (paramView == paramObject);
        }
        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(mList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mList.get(position));

            return mList.get(position);
        }
    }


}
