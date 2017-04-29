package com.orandnot.neteasemusicguide;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class IntroduceTitlesView extends FrameLayout {
    private int widthPixels;
    private TextView tvIn1;
    private TextView tvIn2;
    private TextView tvOut1;
    private TextView tvOut2;
    private String strLeft1;
    private String strLeft2;
    private String strRight1;
    private String strRight2;
    private String str1;
    private String str2;
    View localView1;
    View localView2;

    public IntroduceTitlesView(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public IntroduceTitlesView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    private void init(Context paramContext) {
         localView1 = LayoutInflater.from(paramContext).inflate(R.layout.view_title, this);
        tvIn1 = ((TextView) localView1.findViewById(R.id.cl));
        tvIn2 = ((TextView) localView1.findViewById(R.id.xv));
         localView2 = LayoutInflater.from(paramContext).inflate(R.layout.view_title, null);
        addView(localView2);
        tvOut1 = ((TextView) localView2.findViewById(R.id.cl));
        tvOut2 = ((TextView) localView2.findViewById(R.id.xv));
        widthPixels = getResources().getDisplayMetrics().widthPixels;
    }


    public void setText(String strLeft1, String strLeft2, String str1, String str2, String strRight1, String strRight2) {
        this.strLeft1 = strLeft1;
        this.strLeft2 = strLeft2;
        this.strRight1= strRight1;
        this.strRight2 = strRight2;
        this.str1 = str1;
        this.str2 = str2;
        this.tvIn2.setText(this.str2);
        this.tvIn1.setText(this.str1);
    }



    public void animationRight(){
        this.tvOut1.setText(strLeft1);
        this.tvOut2.setText(strLeft2);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(localView1, "translationX", widthPixels/2, 0);
        animator2.setInterpolator(new LinearOutSlowInInterpolator());
        animator2.setDuration(600L);
        animator2.start();
        ObjectAnimator animator = ObjectAnimator.ofFloat(localView2, "translationX", 0, -(widthPixels+localView2.getWidth())/2);
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        animator.setDuration(800L);
        animator.start();
    }

    public void animationLeft(){
        this.tvOut1.setText(strRight1);
        this.tvOut2.setText(strRight2);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(localView1, "translationX", -widthPixels/2, 0);
        animator2.setInterpolator(new LinearOutSlowInInterpolator());
        animator2.setDuration(600L);
        animator2.start();
        ObjectAnimator animator = ObjectAnimator.ofFloat(localView2, "translationX", 0, (widthPixels+localView2.getWidth())/2);
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        animator.setDuration(800L);
        animator.start();
    }

}