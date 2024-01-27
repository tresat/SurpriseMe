package com.tomtresansky.surpriseme

class JVMSPlatform : Platform {
    override val name: String = "JVM"
}

actual fun getPlatform(): Platform = JVMSPlatform()
