package com.gugalor.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class TitleButton extends Button
{
	private boolean a = false;

	public TitleButton(Context paramContext)
	{
		super(paramContext);
	}

	public TitleButton(Context paramContext, AttributeSet paramAttributeSet)
	{
		super(paramContext, paramAttributeSet);
	}

	public TitleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	{
		super(paramContext, paramAttributeSet, paramInt);
	}

	public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
	{
		if ((paramCharSequence != null) && (!"".equals(paramCharSequence)))
		{
			int i = 3;
			if (this.a)
				i = 2;
			if (paramCharSequence.length() > i + 1)
				paramCharSequence = paramCharSequence.subSequence(0, i) + "...";
		}
		super.setText(paramCharSequence, paramBufferType);
	}
}