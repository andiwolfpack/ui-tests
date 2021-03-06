package com.example.andi.uitests

import android.os.SystemClock
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.example.andi.uitests.CustomAssertions.Companion.hasItemCount
import com.example.andi.uitests.ui.main.MainActivity
import com.example.andi.uitests.ui.main.MainAdapter
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testRecycler() {
        withId(R.id.act_main_rv_guys).matches(hasItemCount(4))
        R.id.act_main_rv_guys.click(0)
        sleep(500)
        activity containsToast "Tibisor"
        sleep(1000)
        R.id.act_main_rv_guys.click(1)
        sleep(500)
        activity containsToast "Alinuts"
        sleep(1000)
        R.id.act_main_rv_guys.click(2)
        sleep(500)
        activity containsToast "Vasilica"
        sleep(1000)
        R.id.act_main_rv_guys.click(3)
        sleep(500)
        activity containsToast "Bogdanel"
    }

    @Test
    fun testToolbar() {
        onView(allOf(isAssignableFrom(TextView::class.java), withParent(isAssignableFrom(Toolbar::class.java))))
                .check(matches(withText(R.string.guys_title)))
        sleep(500)
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.login)).perform(click())
        sleep(500)
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.settings)).perform(click())
    }

    private infix fun ActivityTestRule<MainActivity>.containsToast(message: String) =
            onView(withText(message))
                    .inRoot(withDecorView(not(activity.window.decorView)))
                    .check(matches(isDisplayed()))!!

    private fun Int.click(position: Int) = onView(withId(this))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MainAdapter.ViewHolder>(position, ViewActions.click()))!!

    private fun sleep(time: Long) = SystemClock.sleep(time)
}