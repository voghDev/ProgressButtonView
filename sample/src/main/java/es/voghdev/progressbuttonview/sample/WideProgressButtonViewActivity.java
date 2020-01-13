/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
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
package es.voghdev.progressbuttonview.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class WideProgressButtonViewActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wide_progress_button);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);

        progressButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButtonView.showLoading();

                celebrateVisibilityAfterAFewMillisecs();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (dialog != null) {
            dialog.cancel();
            dialog = null;
        }
    }

    private void celebrateVisibilityAfterAFewMillisecs() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressButtonView.hideLoading();

                Toast.makeText(WideProgressButtonViewActivity.this,
                        "Wow. You're so wide. I'm impressed", Toast.LENGTH_SHORT).show();

                progressButtonView.setText("Now my text has changed");

                showChangeTextDialog();
            }
        }, 1500);
    }

    private void showChangeTextDialog() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("Change button text")
                .setMessage("Do you want to change button text?")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int color = ContextCompat.getColor(WideProgressButtonViewActivity.this, R.color.orange);
                        progressButtonView.setBackgroundColor(color);
                        progressButtonView.setText("Send");
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.show();
    }

}
