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

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.voghdev.progressbuttonview.sample.R;
import es.voghdev.progressbuttonview.sample.ViewWithTintModeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ViewWithBackgroundColorTest {
    @Rule
    public ActivityTestRule<ViewWithTintModeActivity> activityRule =
            new ActivityTestRule<>(ViewWithTintModeActivity.class, true, false);

    @Test
    public void shouldTintAProgressBarWithOnlyTintModeAttribute() throws Exception {
        startActivity();

        onView(withText(R.string.progressButtonView_tint_mode)).perform(click());
        onView(withText(R.string.progressButtonView_visibility_response)).check(matches(isDisplayed()));
    }

    private ViewWithTintModeActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}