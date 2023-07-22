package com.leromaro.proyectofinal

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get : Rule
    var rule : ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_LlenarTextos(){
        onView(withId(R.id.ET_primero)).perform(typeText("hola"))
        onView(withId(R.id.ET_segundo)).perform(typeText("hola"))
        onView(withId(R.id.BTN_comparar)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.TV_resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }
}