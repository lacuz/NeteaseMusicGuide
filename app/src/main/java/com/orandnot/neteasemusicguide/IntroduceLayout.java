package com.orandnot.neteasemusicguide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/4/26.
 */

public class IntroduceLayout extends FrameLayout {

    private int pagerNumber;  // 第几页
    ImageView ivBig;
    ImageView ivMid;
    ImageView ivSmall;
    IntroduceTitlesView titlesView;
    int marginsLeft;
    int secondHeight;

    public IntroduceLayout(Context paramContext, int pagerNumber) {
        super(paramContext);
        this.pagerNumber = pagerNumber;
        View localView1 = LayoutInflater.from(paramContext).inflate(R.layout.layout_introduce, this);
        ivBig = (ImageView) localView1.findViewById(R.id.iv_big);
        ivMid = (ImageView) localView1.findViewById(R.id.iv_mid);
        ivSmall = (ImageView) localView1.findViewById(R.id.iv_small);
        titlesView = (IntroduceTitlesView) localView1.findViewById(R.id.title_view);
        FrameLayout flMain = (FrameLayout) localView1.findViewById(R.id.fl_main);

        float bigHeight = 1F * getResources().getDisplayMetrics().heightPixels / 1920.0F;
        marginsLeft = (int) (41.0F * bigHeight);

        flMain.getLayoutParams().width = (int) (831.0F * bigHeight);
        flMain.getLayoutParams().height = (int) (1248.0F * bigHeight);
        int mPadding = (int) (15.0F * bigHeight);
        flMain.setPadding(mPadding, mPadding, mPadding, mPadding);
        flMain.setTranslationY(12.0F * -bigHeight);
        secondHeight = (int) (bigHeight * 358.0F);
        ivMid.getLayoutParams().width = (int) (236.0F * bigHeight);
        ivMid.getLayoutParams().height = (int) (236.0F * bigHeight);
        ivSmall.getLayoutParams().width = (int) (105.0F * bigHeight);
        ivSmall.getLayoutParams().height = (int) (105.0F * bigHeight);

        localView1.findViewById(R.id.bg).getLayoutParams().height = (int) (1185.0F * bigHeight);


        String str1 = paramContext.getResources().getString(R.string.afj);//个性推荐
        String str2 = paramContext.getResources().getString(R.string.yu);//精彩评论
        String str3 = paramContext.getResources().getString(R.string.axu);//海 量 资 讯
        String str4 = paramContext.getResources().getString(R.string.afk);//每天为悄
        String str5 = paramContext.getResources().getString(R.string.yt);//4 亿 多 条 有 趣 的 故 事，听 歌 再 不 孤 单
        String str6 = paramContext.getResources().getString(R.string.axy);//明 星 动 态、音 乐 热 点 尽 收 眼 底
        switch (pagerNumber) {
            case 0:
                ivBig.setBackgroundDrawable(paramContext.getResources().getDrawable(R.drawable.aej));
                this.titlesView.setText("", "", str1, str4, str3, str6);
                ivSmall.setVisibility(GONE);
                setLayout(ivMid, (int) (bigHeight * 554.0F));
                break;
            case 1:
                ivBig.setBackgroundDrawable(paramContext.getResources().getDrawable(R.drawable.aek));
                this.titlesView.setText(str1, str4, str2, str5, str3, str6);
                setLayout(ivMid, marginsLeft);
                setLayout(ivSmall, secondHeight);
                break;
            case 2:
                ivBig.setBackgroundDrawable(paramContext.getResources().getDrawable(R.drawable.ael));
                ivMid.setVisibility(GONE);
                this.titlesView.setText(str2, str4, str3, str6, "", "");
                setLayout(ivSmall, marginsLeft);
                break;
        }
    }

    public IntroduceLayout(Context context) {
        super(context);
    }

    public IntroduceLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private void setLayout(View paramView, int paramInt) {
        ((LayoutParams) paramView.getLayoutParams()).setMargins(marginsLeft, paramInt, 0, 0);
        paramView.requestLayout();
    }


    private void animatorTranslationY(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationY", secondHeight + marginsLeft, 0);
        animator.setInterpolator(new LinearOutSlowInInterpolator());
        animator.setDuration(400L);
        animator.start();
    }

    public void start(boolean paramBoolean) {
        if (paramBoolean) {
            this.titlesView.animationRight();
            mainnAnimator();
        } else {
            this.titlesView.animationLeft();
        }
    }

    private void mainnAnimator() {
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(ivBig, "alpha", new float[]{0F, 1F});
        localObjectAnimator.setDuration(800L).addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (pagerNumber == 1) {
//                    ObjectAnimator.ofFloat(ivSmall, "alpha", new float[]{0F, 1F}).setDuration(300L).start();
                    animatorTranslationY(ivMid);
                }
                if (pagerNumber == 2)
                    animatorTranslationY(ivSmall);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }
        });

        localObjectAnimator.start();

    }


}
