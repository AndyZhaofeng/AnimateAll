package com.zfeng.animateall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.transitionseverywhere.ArcMotion;
import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.TransitionManager;

/**
 * Created by zhaofeng on 16/7/12.
 */
public class PathMotionActivity extends AppCompatActivity
{
    ViewGroup transitionContainer;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pathmotion_layout);
        transitionContainer=(ViewGroup) findViewById(R.id.transitions_container);
        button=(Button)findViewById(R.id.pathmotionBtn);

        button.setOnClickListener(new View.OnClickListener(){
            boolean isReturnAnimation;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionContainer,new ChangeBounds()
                .setPathMotion(new ArcMotion()).setDuration(500));
                isReturnAnimation=!isReturnAnimation;

                FrameLayout.LayoutParams params=(FrameLayout.LayoutParams)button.getLayoutParams();
                params.gravity=isReturnAnimation?(Gravity.LEFT|Gravity.TOP):
                        (Gravity.BOTTOM|Gravity.RIGHT);
                button.setLayoutParams(params);
            }
        });

    }
}
