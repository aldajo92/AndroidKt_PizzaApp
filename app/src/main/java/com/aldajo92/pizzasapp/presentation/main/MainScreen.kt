package com.aldajo92.pizzasapp.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aldajo92.pizzasapp.presentation.theme.PizzasAppTheme
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val pizzaState = mainViewModel.pizzaFlow.collectAsState()
    val pizzaList = pizzaState.value

    val searchState = mainViewModel.searchFlow.collectAsState()
    val searchText = searchState.value

    val selectedPizzaState = mainViewModel.selectedPizza.collectAsState()
    val selectedPizza = selectedPizzaState.value

    LaunchedEffect(Unit) {
//        delay(3000)
        mainViewModel.getPizzas()
    }

    PizzasAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    value = searchText,
                    onValueChange = {
                        mainViewModel.updateSearch(it)
                    },
                    label = { Text("Search") }
                )
                Text(
                    text = selectedPizza,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                LazyColumn(
                    modifier = Modifier
                ) {
                    items(pizzaList.size) { index ->
                        PizzaItem(
                            name = pizzaList[index],
                            onClick = {
                                mainViewModel.updateSelectedPizza(it)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PizzaItem(
    name: String,
    onClick: (String) -> Unit = {}
) {
    Text(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick(name) },
        text = name
    )
}
