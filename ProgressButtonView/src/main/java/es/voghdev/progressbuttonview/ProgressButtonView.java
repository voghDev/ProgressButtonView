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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class ProgressButtonView extends FrameLayout {
    public static final int NO_DRAWABLE = -1;
    public static final int NO_COLOR = -1;
    public static final float DEFAULT_SIZE = 14f;
    public static final String DEFAULT_TINT_MODE = "src_atop";

    Button button;
    ProgressBar progressBar;

    int textColor;
    boolean hideButtonOnClick = false;
    boolean loading = false;
    String buttonText = "";

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
        bindViewListeners(v);
    }

    protected void bindViewListeners(View v) {
        button = (Button) findViewById(R.id.progress_button_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress_button_progressBar);
    }

    protected int getLayoutId() {
        return R.layout.view_progress_button;
    }

    public void setOnClickListener(OnClickListener l) {
        button.setOnClickListener(l);
    }

    public void setOnLongClickListener(OnLongClickListener l) {
        button.setOnLongClickListener(l);
    }

    public void setText(String text) {
        buttonText = text;
        button.setText(text);
    }

    public void setText(int resId) {
        setText(getContext().getString(resId));
    }

    public CharSequence getText() {
        return button.getText();
    }

    public void setTextColor(int color) {
        button.setTextColor(color);
    }

    public void setTextSize(float textSize) {
        button.setTextSize(textSize);
    }

    public void setEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }

    @SuppressWarnings("NewApi")
    public void setIndeterminateTintMode(PorterDuff.Mode tintMode) {
        progressBar.setIndeterminateTintMode(tintMode);
    }

    @SuppressWarnings("NewApi")
    public void setIndeterminateDrawableTiled(Drawable d) {
        progressBar.setIndeterminateDrawableTiled(d);
    }

    public void setIndeterminateDrawable(Drawable d) {
        progressBar.setIndeterminateDrawable(d);
    }

    public void setIndeterminateDrawableColorFilter(int color, PorterDuff.Mode mode) {
        progressBar.getIndeterminateDrawable().setColorFilter(color, mode);
    }

    public void setIndeterminateDrawableColorFilter(ColorFilter colorFilter) {
        progressBar.getIndeterminateDrawable().setColorFilter(colorFilter);
    }

    @SuppressWarnings("NewApi")
    public void setIndeterminateTintList(ColorStateList tint) {
        progressBar.setIndeterminateTintList(tint);
    }

    public void setBackground(Drawable background) {
        if (Build.VERSION.SDK_INT >= 16 && button != null) {
            button.setBackground(background);
        } else if (Build.VERSION.SDK_INT < 16 && button != null) {
            button.setBackgroundDrawable(background);
        }
    }

    @SuppressLint("NewApi")
    public void setBackgroundTintList(ColorStateList tint) {
        button.setBackgroundTintList(tint);
    }

    @SuppressLint("NewApi")
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        button.setBackgroundTintMode(mode);
    }

    public void setBackgroundResource(int resId) {
        button.setBackgroundResource(resId);
    }

    public void setBackgroundColor(int color) {
        button.setBackgroundColor(color);
    }

    public void setTypeface(Typeface tf) {
        button.setTypeface(tf);
    }

    public void setTypeface(Typeface tf, int style) {
        button.setTypeface(tf, style);
    }

    public void hideButtonOnClick(boolean hide) {
        this.hideButtonOnClick = hide;
    }

    public void setAllCaps(boolean value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            button.setAllCaps(value);
        }
    }

    @SuppressWarnings("NewApi")
    public synchronized void showLoading() {
        boolean isColorDrawable = (button.getBackground() instanceof ColorDrawable);
        if (isColorDrawable) {
            ColorDrawable buttonColor = (ColorDrawable) button.getBackground();
            button.setTextColor(buttonColor.getColor());
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        button.setClickable(false);
        buttonText = button.getText().toString();
        if (hideButtonOnClick) {
            button.setVisibility(View.INVISIBLE);
        } else {
            button.setText(isColorDrawable
                    ? buttonText
                    : buttonText.replaceAll(".", " "));
        }
        loading = true;
    }

    public synchronized void hideLoading() {
        progressBar.setVisibility(ProgressBar.GONE);
        button.setVisibility(View.VISIBLE);
        button.setClickable(true);
        if (buttonText.length() > 0) {
            button.setText(buttonText);
        }
        setTextColor(textColor);
        loading = false;
    }

    public synchronized boolean isLoading() {
        return loading;
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
                            NO_COLOR);
            String text = a.getString(R.styleable.ProgressButtonView_text);
            int drawableResId = a.getResourceId(R.styleable.ProgressButtonView_backgroundDrawable,
                    NO_DRAWABLE);
            boolean hideOnClick = a.getBoolean(R.styleable.ProgressButtonView_hideButtonWhileLoading, false);
            float paddingRight = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingRight, 8f);
            float paddingLeft = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingLeft, 8f);
            float paddingTop = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingTop, 0f);
            float paddingBottom = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingBottom, 0f);
            float textSize = a.getDimension(R.styleable.ProgressButtonView_textSize, 14);
            String tintMode = a.getString(R.styleable.ProgressButtonView_progressBarTintMode);
            int tintColor = a.getColor(R.styleable.ProgressButtonView_progressBarTint, NO_COLOR);
            boolean textAllCaps = a.getBoolean(R.styleable.ProgressButtonView_allCaps, true);

            this.textColor = textColor;
            setTextColor(textColor);
            if (backgroundColor != NO_COLOR) {
                setBackgroundColor(backgroundColor);
            }
            this.hideButtonOnClick(hideOnClick);

            if (text != null) {
                setText(text);
            }

            if (drawableResId != NO_DRAWABLE) {
                setBackground(ContextCompat.getDrawable(getContext(), drawableResId));
                button.setPadding((int) paddingLeft, (int) paddingTop, (int) paddingRight, (int) paddingBottom);
            }

            if (textSize != DEFAULT_SIZE) {
                button.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }

            if (tintColor != NO_COLOR && tintMode == null) {
                tintMode = DEFAULT_TINT_MODE.toUpperCase();
            }

            if (tintColor != NO_COLOR && tintMode != null) {
                PorterDuff.Mode mode = PorterDuff.Mode.valueOf(tintMode.toUpperCase());
                setIndeterminateDrawableColorFilter(tintColor, mode);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                button.setAllCaps(textAllCaps);
            }

            a.recycle();
        }
    }

    //endregion
}