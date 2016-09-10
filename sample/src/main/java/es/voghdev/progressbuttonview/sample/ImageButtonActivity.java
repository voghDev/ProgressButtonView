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
package es.voghdev.progressbuttonview.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressImageButtonView;

public class ImageButtonActivity extends AppCompatActivity {
    ProgressImageButtonView progressImageButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        progressImageButtonView = (ProgressImageButtonView) findViewById(R.id.progressImageButtonView);

        progressImageButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressImageButtonView.showLoading();

                sayHelloAfterAFewMillisecs();
            }
        });
    }

    private void sayHelloAfterAFewMillisecs() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressImageButtonView.hideLoading();

                Toast.makeText(ImageButtonActivity.this, R.string.hello_response, Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }
}
