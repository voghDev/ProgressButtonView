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
import androidx.appcompat.app.AppCompatActivity;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class ViewWithLowerCaseActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_with_lowercase);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);
    }
}
