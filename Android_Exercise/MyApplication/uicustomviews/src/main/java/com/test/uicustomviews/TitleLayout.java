package com.test.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.AbstractSet;
import java.util.jar.Attributes;

/**
 * Created by Shao on 2016-07-24.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attributes) {
        super(context, attributes);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
    }
}
