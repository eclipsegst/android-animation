package com.zhaolongzhong.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhaolongzhong.animation.fragments.BlueFragment;
import com.zhaolongzhong.animation.fragments.OrangeFragment;
import com.zhaolongzhong.animation.fragments.PurpleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {
    private static final String TAG = FragmentActivity.class.getSimpleName();

    @BindView(R.id.blue_right_in_left_out_text_view) TextView blueRightInOutTextView;
    @BindView(R.id.orange_right_in_left_out_text_view) TextView orangeRightInLeftOutTextView;
    @BindView(R.id.purple_right_in_out_text_view) TextView purpleRightInOutTextView;
    @BindView(R.id.purple_bottom_in_out_text_view) TextView purpleBottomInOutTextView;
    @BindView(R.id.fragment_activity_frame_layout_id) FrameLayout frameLayout;

    private boolean leftIn;
    private boolean replaceLeftIn;
    private boolean isPurpleIn;

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, FragmentActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        ButterKnife.bind(this);

        blueRightInOutTextView.setOnClickListener(blueRightInLeftOutOnClickListener);
        orangeRightInLeftOutTextView.setOnClickListener(orangeRightInLeftOutOnClickListener);
        purpleRightInOutTextView.setOnClickListener(purpleRightInOutTextViewOnClickListener);
        purpleBottomInOutTextView.setOnClickListener(purpleBottomInOutTextViewOnClickListener);
    }

    private View.OnClickListener blueRightInLeftOutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (leftIn) {
                getFragmentManager().popBackStackImmediate();
                leftIn = false;
            } else {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.right_in, R.animator.left_out, R.animator.left_in, R.animator.right_out)
                        .replace(R.id.fragment_activity_frame_layout_id, new BlueFragment(), BlueFragment.class.getCanonicalName())
                        .addToBackStack(BlueFragment.class.getCanonicalName())
                        .commit();
                leftIn = true;
            }
        }
    };

    private View.OnClickListener orangeRightInLeftOutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (replaceLeftIn) {
                getFragmentManager().popBackStackImmediate();
                replaceLeftIn = false;
            } else {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.right_in, R.animator.left_out, R.animator.left_in, R.animator.right_out)
                        .replace(R.id.fragment_activity_frame_layout_id, new OrangeFragment(), OrangeFragment.class.getCanonicalName())
                        .addToBackStack(BlueFragment.class.getCanonicalName())
                        .commit();
                replaceLeftIn = true;
            }
        }
    };

    private View.OnClickListener purpleRightInOutTextViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPurpleIn) {
                getFragmentManager().popBackStackImmediate();
                isPurpleIn = false;
            } else {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.right_in, R.animator.stay, R.animator.stay, R.animator.right_out)
                        .add(R.id.fragment_activity_frame_layout_id, new PurpleFragment(), PurpleFragment.class.getCanonicalName())
                        .addToBackStack(BlueFragment.class.getCanonicalName())
                        .commit();
                isPurpleIn = true;
            }
        }
    };

    private View.OnClickListener purpleBottomInOutTextViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isPurpleIn) {
                getFragmentManager().popBackStackImmediate();
                isPurpleIn = false;
            } else {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.bottom_in, R.animator.stay, R.animator.stay, R.animator.bottom_out)
                        .add(R.id.fragment_activity_frame_layout_id, new PurpleFragment(), PurpleFragment.class.getCanonicalName())
                        .addToBackStack(BlueFragment.class.getCanonicalName())
                        .commit();
                isPurpleIn = true;
            }
        }
    };
}
