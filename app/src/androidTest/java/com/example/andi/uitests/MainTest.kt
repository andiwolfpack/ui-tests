package com.example.andi.uitests

import android.os.SystemClock
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
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
    }

    fun Int.click() = onView(withId(this)).perform(ViewActions.click())!!
    fun Int.write(text: String) = onView(withId(this)).perform(typeText(text))!!
    fun Int.textEquals(text: String) = onView(withId(this)).check(matches(withText(text)))!!
    private infix fun ActivityTestRule<MainActivity>.containsToast(message: String) =
            onView(withText(message))
                    .inRoot(withDecorView(not(activity.window.decorView)))
                    .check(matches(isDisplayed()))!!

    fun Int.click(position: Int) = onView(withId(this))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MainAdapter.ViewHolder>(position, ViewActions.click()))

    fun sleep(time: Long) = SystemClock.sleep(time)
}