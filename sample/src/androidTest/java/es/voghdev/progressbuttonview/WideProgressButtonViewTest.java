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
import es.voghdev.progressbuttonview.sample.WideProgressButtonViewActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class WideProgressButtonViewTest {
    @Rule
    public ActivityTestRule<WideProgressButtonViewActivity> activityRule =
            new ActivityTestRule<>(WideProgressButtonViewActivity.class, true, false);

    @Test
    public void shouldDisplayAProgressButtonViewWithWideProgressButtonViewDrawable() {
        startActivity();

        onView(withId(R.id.progressButtonView)).check(matches(isDisplayed()));
        onView(withId(R.id.progressButtonView)).perform(click());
        onView(withText(android.R.string.cancel)).perform(click());
        onView(withText("Now my text has changed")).check(matches(isDisplayed()));
    }

    // Trying to reproduce Issue #10
    @Test
    public void shouldChangeButtonTextProgramatically() {
        startActivity();

        onView(withText("I'm Wide! so so wide!")).check(matches(isDisplayed()));
        onView(withId(R.id.progressButtonView)).perform(click());
        onView(withText(android.R.string.ok)).perform(click());
        onView(withText("Send")).check(matches(isDisplayed()));
    }

    // Trying to reproduce Issue #10 (II)
    @Test
    public void shouldChangeButtonTextAfterAcceptingADialogThatChangesBackgroundColor() throws Exception {
        startActivity();

        onView(withId(R.id.progressButtonView)).perform(click());
        onView(withText("Do you want to change button text?")).check(matches(isDisplayed()));

        onView(withId(android.R.id.button1)).perform(click());
        onView(withText("Send")).check(matches(isDisplayed()));
    }

    private WideProgressButtonViewActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}