/*
 * Copyright (C) 2016 Olmo Gallegos Hernández
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.progressbuttonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class ProgressButtonView extends RelativeLayout {
    public static final int NO_DRAWABLE = -1;
    public static final float DEFAULT_SIZE = 14f;

    Button button;
    ProgressBar progressBar;

    private int mTextColor;
    private boolean hideButtonOnClick = false;

    public ProgressButtonView(Context context) {
        super(context);
        initViews();
        style(button, context, null, -1);
    }

    public ProgressButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
        style(button, context, attrs, -1);
    }

    public ProgressButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
        style(button, context, attrs, defStyle);
    }

    private void initViews() {
        View v = inflate(getContext(), getLayoutId(), this);

        button = (Button) v.findViewById(R.id.progress_button_btn);
        progressBar = (ProgressBar) v.findViewById(R.id.progress_button_progressBar);
    }

    public int getLayoutId() {
        return R.layout.view_progress_button;
    }

    public void setOnClickListener(OnClickListener l) {
        button.setOnClickListener(l);
    }

    public void setOnLongClickListener(OnLongClickListener l) {
        button.setOnLongClickListener(l);
    }

    public void setText(String text) {
        button.setText(text);
    }

    public void setText(int resId) {
        setText(getContext().getString(resId));
    }

    public void setTextColor(int color) {
        button.setTextColor(color);
    }

    public void setTextSize(float textSize) {
        button.setTextSize(textSize);
    }

    public void setBackgroundDrawable(Drawable background) {
        button.setBackgroundDrawable(background);
    }

    public void setBackgroundResource(int resId) {
        button.setBackgroundResource(resId);
    }

    public void setBackgroundColor(int color) {
        button.setBackgroundColor(color);
    }

    public void hideButtonOnClick(boolean hide) {
        this.hideButtonOnClick = hide;
    }

    public void showLoading() {
        if (button.getBackground() instanceof ColorDrawable) {
            ColorDrawable buttonColor = (ColorDrawable) button.getBackground();
            button.setTextColor(buttonColor.getColor());
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        button.setClickable(false);
        if (hideButtonOnClick) {
            button.setVisibility(View.INVISIBLE);
        }
    }

    public void hideLoading() {
        progressBar.setVisibility(ProgressBar.GONE);
        button.setVisibility(View.VISIBLE);
        button.setClickable(true);
        setTextColor(mTextColor);
    }

    //region Styling methods
    protected void style(Button button, Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray a;

            a = (defStyle >= 0)
                    ?
                    context.obtainStyledAttributes(attrs, R.styleable.ProgressButtonView, defStyle, 0)
                    :
                    context.obtainStyledAttributes(attrs, R.styleable.ProgressButtonView);

            int textColor = a.getColor(R.styleable.ProgressButtonView_textColor,
                    ContextCompat.getColor(getContext(), android.R.color.white));
            int backgroundColor =
                    a.getColor(R.styleable.ProgressButtonView_backgroundColorResource,
                            ContextCompat.getColor(getContext(), R.color.progressButtonView_default_color));
            String text = a.getString(R.styleable.ProgressButtonView_text);
            int drawableResId = a.getResourceId(R.styleable.ProgressButtonView_backgroundDrawable,
                    R.drawable.progressbuttonview_rounded_corners);
            boolean hideOnClick = a.getBoolean(R.styleable.ProgressButtonView_hideButtonWhileLoading, false);
            float paddingRight = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingRight, 8f);
            float paddingLeft = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingLeft, 8f);
            float paddingTop = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingTop, 0f);
            float paddingBottom = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingBottom, 0f);
            float textSize = a.getDimension(R.styleable.ProgressButtonView_textSize, 14);

            mTextColor = textColor;
            setTextColor(textColor);
            setBackgroundColor(backgroundColor);
            this.hideButtonOnClick(hideOnClick);

            if (text != null) {
                setText(text);
            }

            if (drawableResId != NO_DRAWABLE) {
                setBackgroundDrawable(ContextCompat.getDrawable(getContext(), drawableResId));
                button.setPadding((int) paddingLeft, (int) paddingTop, (int) paddingRight, (int) paddingBottom);
            }

            if (textSize != DEFAULT_SIZE) {
                button.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }

            a.recycle();
        }
    }

    //endregion
}