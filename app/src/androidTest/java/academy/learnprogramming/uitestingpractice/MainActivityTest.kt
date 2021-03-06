package academy.learnprogramming.uitestingpractice

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun activityIsInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun titleAndNextButtonAreVisible() {
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))

    }

    @Test
    fun titleTextIsDisplayed() {
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

   @Test
   fun buttonTapkNavigatesToSecondaryActivity() {
       onView(withId(R.id.button_next_activity)).perform(click())

       onView(withId(R.id.secondary)).check(matches(isDisplayed()))
   }

    @Test
    fun backButtonTapOnSecondaryActivityNavigatesBackToMainActivity() {
        onView(withId(R.id.button_next_activity)).perform(click())

        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        onView(withId(R.id.button_back)).perform(click())

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun systemBackTapFromSecondaryActivityNavigatesBackToMainActivity() {
        onView(withId(R.id.button_next_activity)).perform(click())

        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
