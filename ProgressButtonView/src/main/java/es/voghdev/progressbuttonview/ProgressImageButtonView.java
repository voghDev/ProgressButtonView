package es.voghdev.progressbuttonview;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by olmo on 8/09/16.
 */
public class ProgressImageButtonView extends ProgressButtonView {
    public ProgressImageButtonView(Context context) {
        super(context);
    }

    public ProgressImageButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressImageButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_progress_image_button;
    }
}
