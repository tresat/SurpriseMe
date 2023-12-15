package com.tomtresansky.surpriseme

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        runBlocking {
            assertTrue(getGreetings().any { it.startsWith("iOS") }, "Check iOS is mentioned")
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