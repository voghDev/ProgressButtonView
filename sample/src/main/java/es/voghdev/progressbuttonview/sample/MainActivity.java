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

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import es.voghdev.progressbuttonview.ProgressButtonView;

public class MainActivity extends AppCompatActivity {
    ProgressButtonView progressButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressButtonView = (ProgressButtonView) findViewById(R.id.progressButtonView);

        progressButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressButtonView.showLoading();

                sayHelloAfterAFewMillisecs();
            }
        });
    }

    private void sayHelloAfterAFewMillisecs() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressButtonView.hideLoading();

                Toast.makeText(MainActivity.this, R.string.hello_response, Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sample2) {
            Intent intent = new Intent(this, ViewWithWrongAttributesActivity.class);
            startActivity(intent);
            return false;
        } else if (id == R.id.action_sample3) {
            Intent intent = new Intent(this, ViewWithTwoBackgroundsActivity.class);
            startActivity(intent);
            return false;
        } else if (id == R.id.action_sample4) {
            Intent intent = new Intent(this, ImageButtonActivity.class);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

}
