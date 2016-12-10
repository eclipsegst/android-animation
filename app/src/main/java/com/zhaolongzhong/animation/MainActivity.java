package com.zhaolongzhong.animation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.main_activity_explode_text_view_id) TextView explodeTextView;
    @BindView(R.id.main_activity_slide_text_view_id) TextView slideTextView;
    @BindView(R.id.main_activity_fade_text_view_id) TextView fadeTextView;
    @BindView(R.id.main_activity_fragment_text_view_id) TextView fragmentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        explodeTextView.setOnClickListener(explodeOnClickListener);
        slideTextView.setOnClickListener(slideOnClickListener);
        fadeTextView.setOnClickListener(fadeOnClickListener);
        fragmentTextView.setOnClickListener(fragmentOnClickListener);
    }

    private View.OnClickListener explodeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Transition explodeTransform = TransitionInflater.from(MainActivity.this).
                        inflateTransition(R.transition.explode);
                getWindow().setExitTransition(explodeTransform);

            }
            ExplodeActivity.newInstance(MainActivity.this);
        }
    };

    private View.OnClickListener slideOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SlideActivity.newInstance(MainActivity.this);

            // right to left
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    };

    private View.OnClickListener fadeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FadeActivity.newInstance(MainActivity.this);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };

    private View.OnClickListener fragmentOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentActivity.newInstance(MainActivity.this);
        }
    };
}
