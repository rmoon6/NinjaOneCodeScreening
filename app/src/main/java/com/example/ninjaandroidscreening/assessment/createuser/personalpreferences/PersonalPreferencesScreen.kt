package com.example.ninjaandroidscreening.assessment.createuser.personalpreferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ninjaandroidscreening.ui.SelectableListBottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalPreferencesScreen(onNextScreenClicked: () -> Unit) {
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(
            skipPartiallyExpanded = true,
            density = LocalDensity.current,
            initialValue = SheetValue.Hidden,
        )
    )

    // TODO STOPSHOP replace with view model stuff
    var selectedPet by remember { mutableStateOf<String?>(null) }
    var selectedInterest by remember { mutableStateOf<String?>(null) }
    var isShowingPetsSheet by remember { mutableStateOf(false) }

    BottomSheetScaffold(
        scaffoldState = bottomSheetState,
        sheetContent = {
            if (isShowingPetsSheet) {
                SelectableListBottomSheet(
                    list = listOf("interest1", "interest2", "interest3"),  // TODO STOPSHIP update me to use view model stuff
                    selectedItem = "interest1",    // TODO STOPSHIP update me to use view model stuff
                    onItemClick = {
                        scope.launch { bottomSheetState.bottomSheetState.hide() }
                    }  // TODO STOPSHIP update me to use view model stuff
                )
            } else {
                SelectableListBottomSheet(
                    list = listOf("pet1", "pet2", "pet3"),  // TODO STOPSHIP update me to use view model stuff
                    selectedItem = "pet1",    // TODO STOPSHIP update me to use view model stuff
                    onItemClick = {
                        scope.launch { bottomSheetState.bottomSheetState.hide() }
                    }  // TODO STOPSHIP update me to use view model stuff
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
                selectedOption = selectedPet,
                onClick = {
                    isShowingPetsSheet = true
                    scope.launch { bottomSheetState.bottomSheetState.expand() }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SelectableField(
                label = "Select Interest",
                selectedOption = selectedInterest,
                onClick = {
                    isShowingPetsSheet = false
                    scope.launch { bottomSheetState.bottomSheetState.expand() }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onNextScreenClicked,
                modifier = Modifier.fillMaxWidth(),
                enabled = selectedPet != null && selectedInterest != null
            ) {
                Text("Go to Next Screen")
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

@Preview(showBackground = true)
@Composable
private fun PersonalPreferencesScreenPreview() {
    PersonalPreferencesScreen(onNextScreenClicked = {})
}
