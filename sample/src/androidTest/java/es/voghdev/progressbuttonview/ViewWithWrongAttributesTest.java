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
package es.voghdev.progressbuttonview;

import androidx.test.rule.ActivityTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.voghdev.progressbuttonview.sample.R;
import es.voghdev.progressbuttonview.sample.ViewWithWrongAttributesActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewWithWrongAttributesTest {
    @Rule
    public ActivityTestRule<ViewWithWrongAttributesActivity> activityRule =
            new ActivityTestRule<>(ViewWithWrongAttributesActivity.class, true, false);

    @Test
    public void shouldNotCrashWhenViewWithWrongAttributesIsDisplayed() {
        startActivity();

        onView(withText(R.string.progressButtonView_no_crash_promise)).check(matches(isDisplayed()));
    }


    private ViewWithWrongAttributesActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}