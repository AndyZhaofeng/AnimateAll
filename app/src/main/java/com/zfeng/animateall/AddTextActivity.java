package com.zfeng.animateall;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zhaofeng on 16/7/11.
 */
public class AddTextActivity extends AppCompatActivity {

    ViewGroup transitionContainer;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtext_layout);
        transitionContainer=(ViewGroup) findViewById(R.id.transitions_container);
        text=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            boolean visible;

            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
                {
                    //如果去掉这条语句，动画会显的十分生硬
                    TransitionManager.beginDelayedTransition(transitionContainer);
                    visible=!visible;
                    text.setVisibility(visible?View.VISIBLE:View.GONE);
                }
            }
        });
    }
}