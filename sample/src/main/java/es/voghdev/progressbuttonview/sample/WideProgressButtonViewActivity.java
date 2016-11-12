package es.voghdev.progressbuttonview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressButtonView;

/**
 * Created by olmo on 12/11/16.
 */
public class WideProgressButtonViewActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(es.voghdev.progressbuttonview.R.layout.activity_wide_progress_button);

        progressButtonView = (ProgressButtonView) findViewById(es.voghdev.progressbuttonview.R.id.progressButtonView);

        progressButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButtonView.showLoading();

                celebrateVisibilityAfterAFewMillisecs();
            }
        });
    }

    private void celebrateVisibilityAfterAFewMillisecs() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressButtonView.hideLoading();

                Toast.makeText(WideProgressButtonViewActivity.this,
                        "Wow. You're so wide. I'm impressed", Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

}
