package com.zhaolongzhong.animation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SlideDetailActivity extends AppCompatActivity {
    private static final String TAG = SlideDetailActivity.class.getSimpleName();

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, SlideDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_detail_activity);
    }
}
