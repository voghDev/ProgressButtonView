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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class ProgressImageButtonView extends ProgressButtonView {
    ImageButton imageButton;

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
        imageButton = (ImageButton) v.findViewById(R.id.progress_image_button_btn);
        progressBar = (ProgressBar) v.findViewById(R.id.progress_image_button_progressBar);
    }

    @Override
    protected void style(Button button, Context context, AttributeSet attrs, int defStyle) {

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
        /* Empty */
    }

    public void setBackgroundResource(int resId) {
        button.setBackgroundResource(resId);
    }

    public void setBackgroundColor(int color) {
        /* Empty */
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_progress_image_button;
    }

    public synchronized void showLoading() {
        boolean isColorDrawable = (imageButton.getBackground() instanceof ColorDrawable);
        if (isColorDrawable) {
            ColorDrawable buttonColor = (ColorDrawable) imageButton.getBackground();
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
        imageButton.setClickable(false);
        // Button src
        if (hideButtonOnClick) {
            imageButton.setVisibility(View.INVISIBLE);
        } else {
//            imageButton.setImageDrawable(isColorDrawable
//                    ? buttonText
//                    : buttonText.replaceAll(".", " "));
        }
        loading = true;
    }

    public synchronized void hideLoading() {
        progressBar.setVisibility(ProgressBar.GONE);
        imageButton.setVisibility(View.VISIBLE);
        imageButton.setClickable(true);
        if (buttonText.length() > 0) {
//            imageButton.setSrc(buttonText);
        }
        loading = false;
    }
}
