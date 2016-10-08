package es.voghdev.progressbuttonview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class CustomProgressBarActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress_bar);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);

        progressButtonView.setIndeterminateDrawableColorFilter(0xFFFF00FF,
                android.graphics.PorterDuff.Mode.MULTIPLY);

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

                Toast.makeText(CustomProgressBarActivity.this,
                        "Have you seen my cool ProgressBar drawable?", Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

}
