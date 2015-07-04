package com.gugalor.adapter;

/**
 * Created by Administrator on 2015/6/29.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class MyGridView extends GridView
{
    public MyGridView(Context paramContext)
    {
        super(paramContext);
    }

    public MyGridView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public MyGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void onMeasure(int paramInt1, int paramInt2)
    {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, MeasureSpec.AT_MOST));

    }
}
