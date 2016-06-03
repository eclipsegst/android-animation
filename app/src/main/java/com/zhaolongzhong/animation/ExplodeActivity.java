package com.zhaolongzhong.animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

public class ExplodeActivity extends AppCompatActivity {
    private static final String TAG = ExplodeActivity.class.getSimpleName();

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ExplodeActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context).toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.explode_activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explodeTransform = TransitionInflater.from(this).
                    inflateTransition(R.transition.explode);
            getWindow().setEnterTransition(explodeTransform);

        }
    }
}
