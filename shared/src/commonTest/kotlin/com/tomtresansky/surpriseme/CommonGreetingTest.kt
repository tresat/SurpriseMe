package com.tomtresansky.surpriseme

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {
    @Test
    fun testExample() {
        runBlocking {
            val greetings = getGreetings()
            assertTrue(greetings.contains("Hello!").or(greetings.contains("Hi!")), "Check 'Hello! or Hi!' is mentioned")
        }
    }

    private suspend fun getGreetings(): List<String> {
        val result = mutableListOf<String>()
        Greeting().greet().collect { phrase ->
            result.add(phrase)
        }
        return result
    }
}
