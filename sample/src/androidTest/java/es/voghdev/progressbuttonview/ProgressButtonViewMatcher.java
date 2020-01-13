package es.voghdev.progressbuttonview;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static org.hamcrest.core.Is.is;

public class ProgressButtonViewMatcher {

    public static ViewInteraction onLoadingProgressButtonView(boolean loading) {
        return onView(isAssignableFrom(ProgressButtonView.class)).check(matches(isLoading(is(true))));
    }

    private static Matcher<Object> isLoading(final Matcher<Boolean> loadingMatcher) {
        return new BoundedMatcher<Object, ProgressButtonView>(ProgressButtonView.class) {
            @Override
            public boolean matchesSafely(ProgressButtonView progressButtonView) {
                return progressButtonView.isLoading();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(", which is loading");
            }
        };
    }
}
