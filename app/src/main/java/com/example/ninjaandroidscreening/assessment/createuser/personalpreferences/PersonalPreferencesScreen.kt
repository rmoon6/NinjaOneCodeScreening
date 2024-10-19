package com.example.ninjaandroidscreening.assessment.createuser.personalpreferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    var selectedPet by remember { mutableStateOf<String?>(null) }
    var selectedInterest by remember { mutableStateOf<String?>(null) }
    var isShowingPetsSheet by remember { mutableStateOf(false) }

    BottomSheetScaffold(
        scaffoldState = bottomSheetState,
        sheetContent = {
            if (isShowingPetsSheet) {
                PetsBottomSheet { pet ->
                    selectedPet = pet
                    scope.launch { bottomSheetState.bottomSheetState.hide() }
                }
            } else {
                InterestsBottomSheet { interest ->
                    selectedInterest = interest
                    scope.launch { bottomSheetState.bottomSheetState.hide() }
                }
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
fun SelectableField(label: String, selectedOption: String?, onClick: () -> Unit) {
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

@Composable
fun PetsBottomSheet(onPetSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Select a Pet", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        listOf("Dog", "Cat", "Bird").forEach { pet ->
            Text(
                text = pet,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPetSelected(pet) }
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun InterestsBottomSheet(onInterestSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Select an Interest", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        listOf("Sports", "Music", "Travel").forEach { interest ->
            Text(
                text = interest,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onInterestSelected(interest) }
                    .padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalSheetTemp() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }) {
                    Text("Hide bottom sheet")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PersonalPreferencesScreenPreview() {
    PersonalPreferencesScreen(onNextScreenClicked = {})
}

@Preview(showBackground = true)
@Composable
private fun ModalSheetTempPreview() {
    PersonalPreferencesScreen(onNextScreenClicked = {})
}

