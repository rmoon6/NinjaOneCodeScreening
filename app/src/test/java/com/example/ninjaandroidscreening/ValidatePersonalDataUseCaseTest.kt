package com.example.ninjaandroidscreening

import com.example.ninjaandroidscreening.createuserscreen.personaldata.internal.ValidatePersonalDataUseCase
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ValidatePersonalDataUseCaseTest {

    private lateinit var validatePersonalDataUseCase: ValidatePersonalDataUseCase

    @Before
    fun setup() {
        validatePersonalDataUseCase = ValidatePersonalDataUseCase()
    }

    @Test
    fun `valid email and valid password returns true`() {
        val result = validatePersonalDataUseCase(
            email = "test@example.com",
            password = "Password123"
        )
        assertTrue(result)
    }

    @Test
    fun `empty email returns false`() {
        val result = validatePersonalDataUseCase(
            email = "",
            password = "Password123"
        )
        assertFalse(result)
    }

    @Test
    fun `invalid email format returns false`() {
        val result = validatePersonalDataUseCase(
            email = "invalid-email",
            password = "Password123"
        )
        assertFalse(result)
    }

    @Test
    fun `password with less than 6 characters returns false`() {
        val result = validatePersonalDataUseCase(
            email = "test@example.com",
            password = "Pas12"
        )
        assertFalse(result)
    }

    @Test
    fun `password without a digit returns false`() {
        val result = validatePersonalDataUseCase(
            email = "test@example.com",
            password = "Password"
        )
        assertFalse(result)
    }

    @Test
    fun `password without a letter returns false`() {
        val result = validatePersonalDataUseCase(
            email = "test@example.com",
            password = "123456"
        )
        assertFalse(result)
    }

    @Test
    fun `email with whitespace only returns false`() {
        val result = validatePersonalDataUseCase(
            email = "   ",
            password = "Password123"
        )
        assertFalse(result)
    }
}
