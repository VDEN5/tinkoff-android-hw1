package com.example.a250924

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a250924.ui.theme._250924Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _250924Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MessageListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MessageListScreen(modifier: Modifier = Modifier) {
    var messageText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<String>() }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Поле ввода текста
        TextField(
            value = messageText,
            onValueChange = { messageText = it },
            label = { Text("Введите шутку") },
            modifier = Modifier.fillMaxWidth()
        )

        // Кнопка "Отправить"
        Button(onClick = {
            if (messageText.isNotBlank()) {
                messages.add(messageText)
                messageText = "" // Очистка поля ввода
            }
        }) {
            Text("Отправить шутку")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Список шуток
        LazyColumn {
            items(messages) { message ->
                Text(text = message)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageListScreenPreview() {
    _250924Theme {
        MessageListScreen()
    }
}
//решил начать реализовать штуку, которая из условия взята,
//а не просто печатать "привет мир"