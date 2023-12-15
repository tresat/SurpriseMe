package com.tomtresansky.surpriseme

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import com.tomtresansky.surpriseme.datamodel.Datamodel
import kotlin.random.Random
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val rocketComponent = RocketComponent()
    private val platform: Platform = getPlatform()

    @NativeCoroutines
    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit(Datamodel.testMsg())
        delay(1.seconds)
        emit(platform.name)
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}")
        delay(1.seconds)
        emit(daysPhrase())
        emit(rocketComponent.launchPhrase())
    }
}
