package com.example.lab1cs407

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class TipInstrumentedTests {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun calculateTest_ShouldBe160Total() {

        onView(withId(R.id.billAmt))
            .perform(typeText("150.00") , closeSoftKeyboard() )

        onView(withId(R.id.tipSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("7")))
            .perform(click())
        onView(withId(R.id.tipSpinner))
            .check(matches(withSpinnerText(containsString("7"))))

        onView(withId(R.id.peopleSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("6")))
            .perform(click())
        onView(withId(R.id.peopleSpinner))
            .check(matches(withSpinnerText(containsString("6"))))

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText("$10.50")))

        onView(withId(R.id.eachPayResult))
            .check(matches(withText("$26.75")))

        onView(withId(R.id.totalAmtResult))
            .check(matches(withText("$160.50")))


    }

    @Test
    fun calculateTest_ShouldBe223Total() {

        onView(withId(R.id.billAmt))
            .perform(typeText("212.60") , closeSoftKeyboard() )

        onView(withId(R.id.tipSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("5")))
            .perform(click())
        onView(withId(R.id.tipSpinner))
            .check(matches(withSpinnerText(containsString("5"))))

        onView(withId(R.id.peopleSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("4")))
            .perform(click())
        onView(withId(R.id.peopleSpinner))
            .check(matches(withSpinnerText(containsString("4"))))

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText("$10.63")))

        onView(withId(R.id.eachPayResult))
            .check(matches(withText("$55.81")))

        onView(withId(R.id.totalAmtResult))
            .check(matches(withText("$223.23")))


    }

    @Test
    fun calculateTest_ShouldBe110Total() {

        onView(withId(R.id.billAmt))
            .perform(typeText("100.00") , closeSoftKeyboard() )

        onView(withId(R.id.tipSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("10")))
            .perform(click())
        onView(withId(R.id.tipSpinner))
            .check(matches(withSpinnerText(containsString("10"))))

        onView(withId(R.id.peopleSpinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("10")))
            .perform(click())
        onView(withId(R.id.peopleSpinner))
            .check(matches(withSpinnerText(containsString("10"))))

        onView(withId(R.id.calculateButton)).perform(click())

        onView(withId(R.id.tipResult))
            .check(matches(withText("$10.00")))

        onView(withId(R.id.eachPayResult))
            .check(matches(withText("$11.00")))

        onView(withId(R.id.totalAmtResult))
            .check(matches(withText("$110.00")))


    }
}