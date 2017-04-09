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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(AndroidJUnit4.class)
public class ProgressButtonViewTest {
    @Rule
    public ViewTestRule<ProgressButtonView> viewTestRule = new ViewTestRule<>(R.layout.test_progress_button_view);

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    public ProgressButtonView.Collaborator mockCollaborator;

    @Mock
    public View.OnClickListener mockClickListener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldHaveTheDefaultTextWhenCreated() {
        onView(withId(R.id.progress_button_btn))
                .check(matches(withText("Send")));
    }

    @Test
    public void shouldFireAMethodOnTheCollaboratorWhenClicked() throws Exception {
        ProgressButtonView view = viewTestRule.getView();
        view.setCollaborator(mockCollaborator);
        view.setOnClickListener(mockClickListener);

        onView(withId(R.id.progress_button_root))
                .perform(click());

        verify(mockCollaborator, times(1)).collaborate("Hello");
    }

    @Test
    public void shouldFireACollaboratorMethodWhenShowLoadingIsCalled() throws Exception {
        final ProgressButtonView view = viewTestRule.getView();
        view.setCollaborator(mockCollaborator);

        view.post(new Runnable() {
            @Override
            public void run() {
                view.showLoading();
            }
        });

        waitForAsyncBlocksToFinish();

        verify(mockCollaborator, times(1)).collaborate(any(String.class));
    }

    private void waitForAsyncBlocksToFinish() throws InterruptedException {
        Thread.sleep(30);
    }
}
