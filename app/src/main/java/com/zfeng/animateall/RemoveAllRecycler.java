package com.zfeng.animateall;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.transitionseverywhere.Explode;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.zfeng.animateall.widget.Utils;

/**
 * Created by zhaofeng on 16/7/11.
 */
public class RemoveAllRecycler extends AppCompatActivity
{
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeall_layout);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,RemoveAllAdapter.SpanCount));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 30;
                outRect.left = 7;
            }
        });
        RemoveAllAdapter adapter=new RemoveAllAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void removeItems(View clickedView) {

        //save rect of view in screen coordinates
        final Rect viewRect=new Rect();
        clickedView.getGlobalVisibleRect(viewRect);

        /*Log.d("Version","version="+Build.VERSION.SDK_INT);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            Log.d("Version","explode");
            //create Explode transition with epicenter
            Transition explode=new Explode();
            explode.setEpicenterCallback(new Transition.EpicenterCallback() {
                @Override
                public Rect onGetEpicenter(Transition transition) {
                    return viewRect;
                }
            });
            explode.setDuration(10000);
            TransitionManager.beginDelayedTransition(recyclerView,explode);
        }else if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            TransitionManager.beginDelayedTransition(recyclerView);
        }*/

        //很奇怪没有效果
        TransitionSet set = new TransitionSet()
                .addTransition(new Explode().setEpicenterCallback(new Transition.EpicenterCallback() {
                    @Override
                    public Rect onGetEpicenter(Transition transition) {
                        return viewRect;
                    }
                }).excludeTarget(clickedView, true))
                .addTransition(new Fade().addTarget(clickedView))
                .addListener(new Transition.TransitionListenerAdapter() {
                    @Override
                    public void onTransitionEnd(Transition transition) {
                    }
                });
        TransitionManager.beginDelayedTransition(recyclerView, set);

        //remove all views from Recycler View
        recyclerView.setAdapter(null);

    }

    class RemoveAllAdapter extends RecyclerView.Adapter<RemoveAllAdapter.RemoveAllViewHolder>
    {
        public static final int SpanCount=3;
        Context context;
        int width;

        public RemoveAllAdapter(Context context)
        {
            this.context=context;
            Utils utils=new Utils();
            width=utils.getScreenWith(context)/SpanCount;
        }
        public class RemoveAllViewHolder extends RecyclerView.ViewHolder
        {
            View thisView;
            public RemoveAllViewHolder(View thisView)
            {
                super(thisView);
                this.thisView=thisView;
            }
        }

        @Override
        public RemoveAllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= new View(context);
            ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(width,width);
            view.setLayoutParams(lp);
            view.setBackgroundResource(R.color.colorAccent);
            RemoveAllViewHolder viewHolder=new RemoveAllViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RemoveAllViewHolder holder, int position) {
            holder.thisView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItems(v);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
