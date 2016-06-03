package com.zhaolongzhong.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlideActivity extends AppCompatActivity {
    private static final String TAG = ExplodeActivity.class.getSimpleName();

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, SlideActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.slide_activity_right_to_left_text_view_id) TextView rightToLeftTextView;
    @BindView(R.id.slide_activity_left_to_right_text_view_id) TextView leftToRightTextView;
    @BindView(R.id.slide_activity_top_to_bottom_text_view_id) TextView topToBottomTextView;
    @BindView(R.id.slide_activity_bottom_to_top_text_view_id) TextView bottomToTopTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_activity);
        ButterKnife.bind(this);

        rightToLeftTextView.setOnClickListener(rightToLeftOnClickListener);
        leftToRightTextView.setOnClickListener(leftToRightOnClickListener);
        topToBottomTextView.setOnClickListener(topToBottomOnClickListener);
        bottomToTopTextView.setOnClickListener(bottomToTopOnClickListener);
    }

    private View.OnClickListener rightToLeftOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SlideDetailActivity.newInstance(SlideActivity.this);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    };

    private View.OnClickListener leftToRightOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SlideDetailActivity.newInstance(SlideActivity.this);
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
    };

    private View.OnClickListener topToBottomOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SlideDetailActivity.newInstance(SlideActivity.this);
            overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
        }
    };

    private View.OnClickListener bottomToTopOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SlideDetailActivity.newInstance(SlideActivity.this);
            overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
        }
    };
}
