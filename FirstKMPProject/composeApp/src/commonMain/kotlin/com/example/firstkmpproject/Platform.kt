package com.example.firstkmpproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform