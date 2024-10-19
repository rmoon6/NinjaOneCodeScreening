package com.example.ninjaandroidscreening.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Interest
import com.example.ninjaandroidscreening.assessment.createuserscreen.personalpreferences.Pet
import com.example.ninjaandroidscreening.assessment.userdb.UserDao
import com.example.ninjaandroidscreening.assessment.userdb.UserEntity
import com.example.ninjaandroidscreening.ui.dashboard.internal.DashboardViewModelImpl
import com.example.ninjaandroidscreening.ui.theme.NinjaAndroidScreeningTheme

@Composable
fun DashboardScreen(
    modifier: Modifier,
    viewModel: DashboardViewModel,
    addUserSelected: () -> Unit
) {
    val users by viewModel.users.collectAsState()
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
            onClick = addUserSelected,
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

////////////////////////////////////////////////////////////////////////////////////////////////
/////// PREVIEW STUFF
////////////////////////////////////////////////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    NinjaAndroidScreeningTheme {
        DashboardScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = DashboardViewModelImpl(NoOpUserDao),
            addUserSelected = {}
        )
    }
}

private object NoOpUserDao : UserDao {
    override suspend fun insertUser(user: UserEntity) {}
    override suspend fun getAllUsers(): List<UserEntity> {
        return listOf(
            UserEntity(email = "john@example.com", pet = Pet.DOG, interest = Interest.MUSIC),
            UserEntity(email = "jane@example.com", pet = Pet.CAT, interest = Interest.READING)
        )
    }
}
