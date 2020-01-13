/*
 * Copyright (C) 2017 Olmo Gallegos Hernández.
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

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.voghdev.progressbuttonview.sample.SetTextIssueActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SetTextIssueTest {
    @Rule
    public ActivityTestRule<SetTextIssueActivity> activityRule =
            new ActivityTestRule<>(SetTextIssueActivity.class, true, false);

    @Test
    public void shouldShowTheCorrectTextAfterShowingAndHidingLoading() throws Exception {
        startActivity();

        onView(withText("Text Before")).check(matches(isDisplayed()));
        onView(withText("Text Before")).perform(click());
        onView(withText("Text Before")).check(doesNotExist());
        onView(withText("Text After")).check(matches(isDisplayed()));
    }

    private SetTextIssueActivity startActivity() {
        return activityRule.launchActivity(null);
    }
}
