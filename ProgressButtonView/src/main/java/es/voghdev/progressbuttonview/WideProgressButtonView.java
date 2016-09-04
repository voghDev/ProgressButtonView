package es.voghdev.progressbuttonview;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by olmo on 4/09/16.
 */
public class WideProgressButtonView extends ProgressButtonView {
    public WideProgressButtonView(Context context) {
        super(context);
    }

    public WideProgressButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WideProgressButtonView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_wide_progress_button;
    }
}
