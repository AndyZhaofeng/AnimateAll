package com.zfeng.animateall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.transitionseverywhere.TransitionManager;
import com.zfeng.animateall.widget.ProgressTransition;

/**
 * Created by zhaofeng on 16/7/12.
 */
public class CustomTransitionActivity extends AppCompatActivity
{
    Button btn;
    ProgressBar progressBar;
    ViewGroup transitionContainer;
    int values=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customtransition_layout);
        btn=(Button)findViewById(R.id.add_10);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        transitionContainer=(ViewGroup)findViewById(R.id.linearLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(values<100){
                    values+=10;
                }else{
                    values=0;
                }
                setProgressBar(values);
            }
        });
    }

    private void setProgressBar(int value){
        TransitionManager.beginDelayedTransition(transitionContainer,new ProgressTransition());
        value=Math.max(0,Math.min(100,value));
        progressBar.setProgress(value);
    }
}
