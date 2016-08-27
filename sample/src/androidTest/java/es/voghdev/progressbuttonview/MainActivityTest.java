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
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.voghdev.progressbuttonview.sample.MainActivity;
import es.voghdev.progressbuttonview.sample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void showsSamplesTitle() {
        startActivity();

        onView(withText("Hello!")).check(matches(isDisplayed()));
    }

    @Test
    public void shouldShowButtonAgainAferLoadWhenProgressButtonViewIsClicked() throws Exception {
        startActivity();

        onView(withId(R.id.progressButtonView)).perform(click());
        onView(withId(R.id.progress_button_btn)).check(matches(isDisplayed()));
    }

    private MainActivity startActivity() {
        return activityRule.launchActivity(null);
    }

    public static Matcher<View> isLoading() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("is showing loading state");
            }

            @Override
            public boolean matchesSafely(View view) {
                ProgressButtonView progressButtonView = (ProgressButtonView) view;
                return progressButtonView.isLoading();
            }
        };
    }
}