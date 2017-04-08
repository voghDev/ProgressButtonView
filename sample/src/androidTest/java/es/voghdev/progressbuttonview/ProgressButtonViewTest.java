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

import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.novoda.espresso.ViewTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(AndroidJUnit4.class)
public class ProgressButtonViewTest {
    @Rule
    public ViewTestRule<ProgressButtonView> viewTestRule = new ViewTestRule<>(R.layout.view_progress_button);

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    public ProgressButtonView.Collaborator mockCollaborator;

    @Before
    public void setUp() {

    }

    @Test
    public void shouldHaveTheDefaultTextWhenCreated() {
        onView(withId(R.id.progress_button_btn))
                .check(matches(withText("Send")));
    }

    @Test
    public void shouldDoSomethingOnClick() throws Exception {
        View view = viewTestRule.getView(); // Returns a FrameLayout ?!?
        if (view instanceof ProgressButtonView) {
            ((ProgressButtonView) view).setCollaborator(mockCollaborator);
        }

        onView(withId(R.id.progress_button_root))
                .perform(click());

        verify(mockCollaborator, times(1)).collaborate("Hello");
    }
}
