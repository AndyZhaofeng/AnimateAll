package com.zfeng.animateall;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.transitionseverywhere.Fade;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;

/**
 * Created by zhaofeng on 16/7/12.
 */
public class FadeActivity extends AppCompatActivity
{
    ViewGroup transitionContainer;
    TextView text;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addtext_layout);
        transitionContainer=(ViewGroup) findViewById(R.id.transitions_container);
        text=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            boolean visible;

            @Override
            public void onClick(View v) {

                TransitionSet set=new TransitionSet()
                        .addTransition(new Scale(0.7f))
                        .addTransition(new Fade())
                        .setInterpolator(visible?new LinearOutSlowInInterpolator():
                                new FastOutLinearInInterpolator());
                TransitionManager.beginDelayedTransition(transitionContainer,set);
                visible=!visible;
                text.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });
    }
}
