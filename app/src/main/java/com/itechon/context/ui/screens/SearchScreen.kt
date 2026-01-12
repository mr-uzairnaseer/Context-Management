package com.itechon.context.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.ui.ContextViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: ContextViewModel
) {
    var query by remember { mutableStateOf("") }
    // For MVP, we filter the full list from ViewModel. In production, use a dedicated search flow.
    val allContexts by viewModel.contexts.collectAsState()
    val searchResults = remember(query, allContexts) {
        if (query.isBlank()) emptyList()
        else allContexts.filter { 
            it.title.contains(query, ignoreCase = true) 
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        placeholder = { Text("Search contexts...") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            if (searchResults.isEmpty() && query.isNotBlank()) {
                item {
                    Text(
                        "No results found locally. Remote search not configured in MVP.",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            items(searchResults) { context ->
                ListItem(
                    headlineContent = { Text(context.title) },
                    supportingContent = { Text("Last updated: ${context.updatedAt}") },
                    modifier = Modifier.clickable {
                        navController.navigate("context_detail/${context.id}")
                    }
                )
                HorizontalDivider()
            }
        }
    }
}
