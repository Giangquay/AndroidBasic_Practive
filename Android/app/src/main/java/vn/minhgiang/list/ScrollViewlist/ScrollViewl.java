package vn.minhgiang.list.ScrollViewlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import vn.minhgiang.list.R;

public class ScrollViewl extends AppCompatActivity {
//    private Button buttonScrollUp , buttonScrollDown;
    private Button buttonScrollLeft , buttonScrollRight;
//    private ScrollView scrollView;
    HorizontalScrollView scrollView;

    public static final int SCROLL_DELTA=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scroll_view_vertical);
        setContentView(R.layout.activity_scroll_view_hozizontal);
//        buttonScrollUp=findViewById(R.id.button_scrollUp);
//        buttonScrollDown=findViewById(R.id.button_scrollDown);
        buttonScrollLeft=findViewById(R.id.button_scrollLeft);
        buttonScrollRight=findViewById(R.id.button_scrollRight);
        scrollView=(HorizontalScrollView) findViewById(R.id.horizontalScrollView);

        buttonScrollRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doScrollUp();
                doScrollRight();
            }
        });
        buttonScrollLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doScrollDown();
                doScrollLeft();
            }
        });
    }

    private void doScrollLeft() {

        int x = this.scrollView.getScrollX();
        int y = this.scrollView.getScrollY();

        if(x - SCROLL_DELTA >= 0) {
            this.scrollView.scrollTo(x - SCROLL_DELTA, y);
        }

    }

    private void doScrollRight() {
        int maxAmount = this.scrollView.getMaxScrollAmount();

        int x = this.scrollView.getScrollX();
        int y = this.scrollView.getScrollY();

        if(x + SCROLL_DELTA <= maxAmount) {
            this.scrollView.scrollTo(x + SCROLL_DELTA, y);
        }
    }
    // if you want to vertical scrollView , You change vertical  in Linear Layout
    /*
    private void doScrollDown() {
        int maxAmount=this.scrollView.getMaxScrollAmount();
        int x = this.scrollView.getScrollX();
        int y= this.scrollView.getScrollY();
        if (y+SCROLL_DELTA<=maxAmount)
        {
            this.scrollView.scrollTo(x,y+SCROLL_DELTA);
        }
    }

    private void doScrollUp() {
        int x = this.scrollView.getScrollX();
        int y= this.scrollView.getScrollY();
        if (y-SCROLL_DELTA>=0)
        {
            this.scrollView.scrollTo(x,y-SCROLL_DELTA);
        }
    }

     */
}