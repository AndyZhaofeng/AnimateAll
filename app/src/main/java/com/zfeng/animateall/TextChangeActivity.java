package com.zfeng.animateall;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.TransitionManager;

/**
 * Created by zhaofeng on 16/7/12.
 */
public class TextChangeActivity extends AppCompatActivity {

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
        button.setVisibility(View.GONE);
        text.setVisibility(View.VISIBLE);
        text.setText("啦啦啦啦啦");

        text.setOnClickListener(new View.OnClickListener(){
            boolean visible;

            @Override
            public void onClick(View v) {
                visible=!visible;
                TransitionManager.beginDelayedTransition(transitionContainer,
                        new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
                text.setText(visible?"啦啦啦啦啦":"嗡嗡嗡嗡");
            }
        });
    }
}
