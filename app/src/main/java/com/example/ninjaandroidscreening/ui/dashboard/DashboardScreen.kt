package com.example.ninjaandroidscreening.ui.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Pet
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    users: List<UserEntity>,
    onAddNewUserButtonClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(users) { user ->
                UserItem(user = user)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onAddNewUserButtonClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add New User")
        }
    }
}

@Composable
private fun UserItem(user: UserEntity) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Pet: ${user.pet}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Interest: ${user.interest}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    val users = listOf(
        UserEntity(email = "john@example.com", pet = Pet.DOG, interest = Interest.MUSIC),
        UserEntity(email = "jane@example.com", pet = Pet.CAT, interest = Interest.READING)
    )

    DashboardScreen(
        users = users,
        onAddNewUserButtonClick = {}
    )
}
