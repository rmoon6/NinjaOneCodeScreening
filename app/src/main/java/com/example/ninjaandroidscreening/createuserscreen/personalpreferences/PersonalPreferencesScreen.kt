package com.example.ninjaandroidscreening.createuserscreen.personalpreferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ninjaandroidscreening.createuserscreen.personalpreferences.internal.PersonalPreferencesViewModelImpl
import com.example.ninjaandroidscreening.SelectableListBottomSheet
import com.example.ninjaandroidscreening.theme.NinjaAndroidScreeningTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalPreferencesScreen(
    modifier: Modifier,
    viewModel: PersonalPreferencesViewModel,
    onPreferencesSubmitted: (Pet, Interest) -> Unit
) {
    val selectedPet by viewModel.selectedPet.collectAsState()
    val selectedInterest by viewModel.selectedInterest.collectAsState()
    val isSubmissionEnabled by viewModel.isSubmissionAllowed.collectAsState()
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true,
            density = LocalDensity.current,
            initialValue = SheetValue.Hidden,
        )
    )
    var isShowingPetsSheet by remember { mutableStateOf(false) }

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = bottomSheetState,
        sheetContent = {
            if (isShowingPetsSheet) {
                SelectableListBottomSheet(
                    list = Pet.entries.map { it.displayName },
                    selectedItem = selectedPet?.displayName,
                    onItemClick = { petString ->
                        val petSelected = Pet.entries.first { it.displayName == petString }
                        viewModel.petSelected(petSelected)
                        scope.launch { bottomSheetState.bottomSheetState.hide() }
                    }
                )
            } else {
                SelectableListBottomSheet(
                    list = Interest.entries.map { it.displayName },
                    selectedItem = selectedInterest?.displayName,
                    onItemClick = { petString ->
                        val interestSelected = Interest.entries.first { it.displayName == petString }
                        viewModel.interestSelected(interestSelected)
                        scope.launch { bottomSheetState.bottomSheetState.hide() }
                    }
                )
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SelectableField(
                label = "Select Pet",
                selectedOption = selectedPet?.displayName,
                onClick = {
                    isShowingPetsSheet = true
                    scope.launch { bottomSheetState.bottomSheetState.expand() }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SelectableField(
                label = "Select Interest",
                selectedOption = selectedInterest?.displayName,
                onClick = {
                    isShowingPetsSheet = false
                    scope.launch { bottomSheetState.bottomSheetState.expand() }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = isSubmissionEnabled,
                onClick = { onPreferencesSubmitted.invoke(selectedPet!!, selectedInterest!!) }
            ) {
                Text("Submit")
            }
        }
    }
}

@Composable
private fun SelectableField(label: String, selectedOption: String?, onClick: () -> Unit) {
    TextField(
        value = selectedOption ?: "",
        onValueChange = {},
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        enabled = false,
        trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) }
    )
}

////////////////////////////////////////////////////////////////////////////////////////////////
/////// PREVIEW STUFF
////////////////////////////////////////////////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
private fun PersonalPreferencesScreenPreview() {
    NinjaAndroidScreeningTheme {
        PersonalPreferencesScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = PersonalPreferencesViewModelImpl(),
            onPreferencesSubmitted = { pet, interest -> },
        )
    }
}
