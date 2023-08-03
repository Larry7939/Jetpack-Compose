package com.compose.jetpackcompose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.jetpackcompose.basic.data.Message
import com.compose.jetpackcompose.basic.ui.theme.JetpackComposeTheme
import com.compose.jetpackcompose.basic.ui.theme.Pink80

class BasicActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                var clickCount by remember {
                    mutableStateOf(0)
                }
                val messageList: SnapshotStateList<Message> = remember {
                    mutableStateListOf()
                }
                var messageItemToRemove = Message(-1, "")
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting(clickCount = clickCount) {
                            clickCount += 1
                            messageList.add(Message(clickCount, "메시지 $clickCount 입니다!"))
                        }
                        MessageList(messageList) {
                            run breaker@{
                                messageList.forEach { message ->
                                    if (message.id == it.id) {
                                        messageItemToRemove = it
                                        return@breaker
                                    }
                                }
                            }
                            messageList.remove(messageItemToRemove)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(clickCount: Int, onClick: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Hello Android!")
        Text(text = "클릭된 카운트 $clickCount")
        Button(onClick = { onClick() }) {
            Text(text = "클릭해주세요!")
        }
    }
}

@Composable
fun MessageList(messages: List<Message>, onDeletedClick: (Message) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(messages) { message ->
            MessageItem(message, onDeletedClick = onDeletedClick)
        }
    }
}

@Composable
fun MessageItem(message: Message, onDeletedClick: (Message) -> Unit) {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), shadowElevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "id : ${message.id} msg : ${message.content}")
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { onDeletedClick(message) }) {
                Text(text = "삭제")
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    val a = listOf<String>("World", "Compose")
    JetpackComposeTheme() {
        Surface() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for (i in a) {
                    TestText(name = i)
                }
            }
        }
    }
}


@Composable
fun TestText(name: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 7.dp, horizontal = 14.dp)
    ) {
        Row(Modifier.padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello")
                Text(text = name)
            }

            OutlinedButton(
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(Color.Green),
                onClick = { /*TODO*/ }) {
                Text(text = "Show more", color = Pink80)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JetpackComposeTheme {
//        Greeting("Android")
//    }
//}