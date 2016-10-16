package es.voghdev.progressbuttonview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class CustomProgressBarXMLActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress_bar_xml);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);

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

                Toast.makeText(CustomProgressBarXMLActivity.this,
                        "Have you seen my cool ProgressBar tint color?", Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

}