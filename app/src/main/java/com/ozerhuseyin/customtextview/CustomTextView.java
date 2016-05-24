package com.ozerhuseyin.customtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Huseyin Ozer on 24.05.2016.
 * http://blog.ozerhuseyin.com
 */
public class CustomTextView extends TextView {

    String fontPath;
    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttributes(attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttributes(attrs);
        init();
    }

    /**
     * Tasarım dosyasından verilen property'leri okuyoruz. Burada fontPath property'sini okuduk.
     */
    private void readAttributes(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0);

        try {
            fontPath = a.getString(R.styleable.CustomTextView_fontPath);
        } finally {
            a.recycle();
        }
    }

    /**
     * Font atamasını gerçekleştiriyoruz.
     */
    private void init(){
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), fontPath);
        setTypeface(typeface);
    }

}
