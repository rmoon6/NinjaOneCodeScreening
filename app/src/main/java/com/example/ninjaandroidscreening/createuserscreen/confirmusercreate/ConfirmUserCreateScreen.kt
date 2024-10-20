package com.example.ninjaandroidscreening.createuserscreen.confirmusercreate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.Pet
import com.example.ninjaandroidscreening.theme.NinjaAndroidScreeningTheme

@Composable
internal fun ConfirmCreateUserScreen(
    email: String,
    pet: Pet,
    interest: Interest,
    onUserCreateConfirmed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserDataField(label = "Email", value = email)
        Spacer(modifier = Modifier.height(8.dp))

        UserDataField(label = "Pet", value = pet.displayName)
        Spacer(modifier = Modifier.height(8.dp))

        UserDataField(label = "Interest", value = interest.displayName)
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onUserCreateConfirmed,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create User")
        }
    }
}

@Composable
private fun UserDataField(label: String, value: String) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "$label:", style = MaterialTheme.typography.labelLarge)

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun ConfirmCreateUserScreenPreview() {
    NinjaAndroidScreeningTheme {
        ConfirmCreateUserScreen(
            email = "john.doe@example.com",
            pet = Pet.CAT,
            interest = Interest.GAMING,
            onUserCreateConfirmed = {}
        )
    }
}
