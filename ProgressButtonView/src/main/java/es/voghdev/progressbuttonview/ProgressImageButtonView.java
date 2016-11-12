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
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class ProgressImageButtonView extends ProgressButtonView {
    ImageButton imageButton;
    int buttonDrawableResId = NO_ID;

    public ProgressImageButtonView(Context context) {
        super(context);
    }

    public ProgressImageButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressImageButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void bindViewListeners(View v) {
        imageButton = (ImageButton) findViewById(R.id.progress_image_button_btn);
        progressBar = (ProgressBar) findViewById(R.id.progress_image_button_progressBar);
    }

    @Override
    protected void style(Button button, Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray a;

            a = (defStyle >= 0)
                    ?
                    context.obtainStyledAttributes(attrs, R.styleable.ProgressButtonView, defStyle, 0)
                    :
                    context.obtainStyledAttributes(attrs, R.styleable.ProgressButtonView);

            int backgroundColor =
                    a.getColor(R.styleable.ProgressButtonView_backgroundColorResource,
                            NO_COLOR);
            int drawableResId = a.getResourceId(R.styleable.ProgressButtonView_backgroundDrawable,
                    NO_DRAWABLE);
            int src = a.getResourceId(R.styleable.ProgressButtonView_src,
                    NO_DRAWABLE);
            boolean hideOnClick = a.getBoolean(R.styleable.ProgressButtonView_hideButtonWhileLoading, false);
            float paddingRight = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingRight, 8f);
            float paddingLeft = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingLeft, 8f);
            float paddingTop = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingTop, 0f);
            float paddingBottom = a.getDimension(R.styleable.ProgressButtonView_buttonPaddingBottom, 0f);

            if (backgroundColor != NO_COLOR) {
                setBackgroundColor(backgroundColor);
            }
            this.hideButtonOnClick(hideOnClick);

            if (drawableResId != NO_DRAWABLE) {
                setBackground(ContextCompat.getDrawable(getContext(), drawableResId));
                imageButton.setPadding((int) paddingLeft, (int) paddingTop, (int) paddingRight, (int) paddingBottom);
            }

            if (src != NO_DRAWABLE) {
                buttonDrawableResId = src;
                setImageDrawable(ContextCompat.getDrawable(getContext(), src));
                imageButton.setPadding((int) paddingLeft, (int) paddingTop, (int) paddingRight, (int) paddingBottom);
            }

            // TODO remove inheritance

            a.recycle();
        }
    }

    public void setOnClickListener(OnClickListener l) {
        imageButton.setOnClickListener(l);
    }

    public void setOnLongClickListener(OnLongClickListener l) {
        imageButton.setOnLongClickListener(l);
    }

    public void setText(String text) {
        /* Empty */
    }

    public void setText(int resId) {
        /* Empty */
    }

    public void setTextColor(int color) {
        /* Empty */
    }

    public void setTextSize(float textSize) {
        /* Empty */
    }

    public void setBackground(Drawable background) {
        if (Build.VERSION.SDK_INT >= 16 && button != null) {
            imageButton.setBackground(background);
        } else if (Build.VERSION.SDK_INT < 16 && button != null) {
            imageButton.setBackgroundDrawable(background);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        imageButton.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        imageButton.setImageBitmap(bitmap);
    }

    public void setImageResource(int resId) {
        imageButton.setImageResource(resId);
    }

    public void setImageAlpha(int alpha) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            imageButton.setImageAlpha(alpha);
        }
    }

    public void setBackgroundResource(int resId) {
        imageButton.setBackgroundResource(resId);
    }

    public void setBackgroundColor(int color) {
        imageButton.setBackgroundColor(color);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_progress_image_button;
    }

    public synchronized void showLoading() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        imageButton.setClickable(false);

        if (hideButtonOnClick) {
            imageButton.setVisibility(View.INVISIBLE);
        } else {
            int nullDrawable = 0; // TODO find a proper null
            // TODO investigate about tinting icon like background color
            setImageResource(nullDrawable);
        }
        loading = true;
    }

    public synchronized void hideLoading() {
        progressBar.setVisibility(ProgressBar.GONE);
        imageButton.setVisibility(View.VISIBLE);
        imageButton.setClickable(true);
        if (buttonDrawableResId != NO_ID) {
            setImageResource(buttonDrawableResId);
        }
        loading = false;
    }
}
