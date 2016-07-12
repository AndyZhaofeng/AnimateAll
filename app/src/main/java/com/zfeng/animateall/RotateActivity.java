package com.zfeng.animateall;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.transitionseverywhere.Recolor;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.TransitionManager;

/**
 * Created by zhaofeng on 16/7/12.
 */
public class RotateActivity extends AppCompatActivity
{
    ViewGroup transitionContainer;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addtext_layout);
        transitionContainer=(ViewGroup) findViewById(R.id.transitions_container);
        button=(Button)findViewById(R.id.button);
        button.setText("点击");

        button.setOnClickListener(new View.OnClickListener(){
            boolean isColorsInverted;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionContainer,new Rotate());
                isColorsInverted=!isColorsInverted;
                button.setRotation(isColorsInverted?135:0);
            }
        });

    }
}
