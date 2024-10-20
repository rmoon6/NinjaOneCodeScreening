package com.example.ninjaandroidscreening.createuserscreen.personalpreferences

enum class Pet {
    DOG,
    CAT,
    FISH,
    SNAKE,
    HAMSTER;

    val displayName: String get() = when (this) {
        DOG -> "Dog"
        CAT -> "Cat"
        FISH -> "Fish"
        SNAKE -> "Snake"
        HAMSTER -> "Hamster"
    }
}
