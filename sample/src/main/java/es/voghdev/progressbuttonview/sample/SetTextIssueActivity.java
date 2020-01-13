package es.voghdev.progressbuttonview.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class SetTextIssueActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);
        progressButtonView.setText("Text Before");

        progressButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButtonView.showLoading();
                progressButtonView.setText("Text After");
                progressButtonView.hideLoading();
            }
        });
    }
}
