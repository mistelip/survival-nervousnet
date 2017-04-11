package com.example.irene.survival_v3.quizActivities;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Irene on 26/02/2017.
 */

public class QuizViewPager extends ViewPager {

    public boolean lastSwipeLeft;
    private float initialXValue = 0;
    private SwipeDirection direction;

    public QuizViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.direction = SwipeDirection.all;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.IsSwipeAllowed(event)) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.IsSwipeAllowed(event)) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    private boolean IsSwipeAllowed(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            initialXValue = event.getX();
            return true;
        }

        // All enabled
        if(this.direction == SwipeDirection.all){
            try {
                float diffX = event.getX() - initialXValue;
                if (diffX > 0 ) {
                    // swipe from left to right detected
                    lastSwipeLeft = true;
                }else if (diffX < 0) {
                    // swipe from right to left detected
                    lastSwipeLeft = false;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        }

        // All disabled
        if(direction == SwipeDirection.none )
            return false;

        // Other cases
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            try {
                float diffX = event.getX() - initialXValue;
                if (diffX > 0 && direction == SwipeDirection.right ) {
                    // swipe from left to right detected
                    return false;
                }else if (diffX < 0 && direction == SwipeDirection.left ) {
                    // swipe from right to left detected
                    return false;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        lastSwipeLeft = true;
        return true;
    }

    public void setAllowedSwipeDirection(SwipeDirection direction) {
        this.direction = direction;
    }

}
