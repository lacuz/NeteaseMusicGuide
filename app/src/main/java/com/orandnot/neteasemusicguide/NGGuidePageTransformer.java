package com.orandnot.neteasemusicguide;

import android.support.v4.view.ViewPager;
import android.view.View;

public class NGGuidePageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_ALPHA = 0.0f;
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        if (position < -1) {
            view.setAlpha(0);  
  
        } else if (position <= 1) { // [-1,1]  
            if (position < 0) {
                view.setTranslationX(-pageWidth * position);
            } else {
                view.setTranslationX(pageWidth);
                view.setTranslationX(-pageWidth * position);
            }
            float alphaFactor = Math.max(MIN_ALPHA, 1 - Math.abs(position));
            view.setAlpha(alphaFactor);  
        } else {
            view.setAlpha(0);  
        }  
    }  

  
}  