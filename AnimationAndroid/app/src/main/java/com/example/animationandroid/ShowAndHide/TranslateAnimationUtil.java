package com.example.animationandroid.ShowAndHide;

import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.animationandroid.R;

public class TranslateAnimationUtil implements View.OnTouchListener{
    private GestureDetector mGestureDetector;

    public TranslateAnimationUtil(Context mContext, View view) {
        mGestureDetector = new GestureDetector(mContext,new SimpleGestureDetector(view));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    public  class SimpleGestureDetector extends GestureDetector.SimpleOnGestureListener
    {
        private View mviViewAnimation;
        private boolean isFinishAnimation=true;

        public SimpleGestureDetector(View mviViewAnimation) {
            this.mviViewAnimation = mviViewAnimation;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
             if (distanceY>0)
            {
                    HideView();
            }else
            {
                ShowView();
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        private void HideView() {
            if (mviViewAnimation==null||mviViewAnimation.getVisibility()==View.GONE)
            {
                return;
            }
            Animation animationDown=new AnimationUtils().loadAnimation(mviViewAnimation.getContext(),R.anim.bottom_up);
            animationDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mviViewAnimation.setVisibility(View.VISIBLE);
                    isFinishAnimation=false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mviViewAnimation.setVisibility(View.GONE);
                    isFinishAnimation=true;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            if (isFinishAnimation)
            {
                mviViewAnimation.startAnimation(animationDown);
            }

        }
        private void ShowView() {
            if (mviViewAnimation==null||mviViewAnimation.getVisibility()==View.VISIBLE)
            {
                return;
            }
            Animation animationUP = new AnimationUtils().loadAnimation(mviViewAnimation.getContext(), R.anim.bottom_up);
            animationUP.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mviViewAnimation.setVisibility(View.VISIBLE);
                    isFinishAnimation=false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isFinishAnimation=true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            if (isFinishAnimation==true)
            {
                mviViewAnimation.startAnimation(animationUP);
            }
        }
    }
}
