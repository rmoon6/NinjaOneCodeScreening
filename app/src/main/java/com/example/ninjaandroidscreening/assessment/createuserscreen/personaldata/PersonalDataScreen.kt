package com.example.ninjaandroidscreening.assessment.createuserscreen.personaldata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ninjaandroidscreening.assessment.createuserscreen.personaldata.internal.PersonalDataViewModelImpl
import com.example.ninjaandroidscreening.assessment.createuserscreen.personaldata.internal.ValidatePersonalDataUseCase
import com.example.ninjaandroidscreening.ui.theme.NinjaAndroidScreeningTheme

@Composable
fun PersonalDataScreen(
    modifier: Modifier,
    viewModel: PersonalDataViewModel,
    callbacks: PersonalDataScreenCallbacks
) {
    val email by viewModel.enteredEmail.collectAsState()
    val password by viewModel.enteredPassword.collectAsState()
    val isSubmissionAllowed by viewModel.isSubmissionAllowed.collectAsState()

    Column(
        modifier = modifier.imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(
            text = "Personal Data",
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 24.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { viewModel.emailUpdated(it) },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = password,
            onValueChange = { viewModel.passwordUpdated(it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { callbacks.userSubmittedPersonalData(email, password) },
            enabled = isSubmissionAllowed
        ) {
            Text("Next")
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
/////// PREVIEW STUFF
////////////////////////////////////////////////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
private fun PersonalDataScreenPreview() {
    NinjaAndroidScreeningTheme {
        PersonalDataScreen(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            viewModel = PersonalDataViewModelImpl(ValidatePersonalDataUseCase()),
            callbacks = NoOpCallbacks
        )
    }
}

private object NoOpCallbacks : PersonalDataScreenCallbacks {
    override fun userSubmittedPersonalData(email: String, password: String) {}
}
