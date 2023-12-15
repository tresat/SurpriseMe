package com.tomtresansky.surpriseme

import kotlinx.coroutines.runBlocking
import org.junit.Test

class AndroidGreetingTest {
    @Test
    fun testExample() {
        runBlocking {
            val greetings = getGreetings()
            kotlin.test.assertTrue(greetings.any { it.startsWith("Android") }, "Check Android is mentioned")
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