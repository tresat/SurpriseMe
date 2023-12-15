package com.tomtresansky.surpriseme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform