package com.zfeng.animateall.widget;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by zhaofeng on 16/7/11.
 */
public class Utils
{
    public int getScreenWith(Context context)
    {
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Point point=new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }
}
