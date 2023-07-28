package com.compose.jetpackcompose.ui.week2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Week2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeveloperTypeSurveyPreview()
        }
    }
}

@Composable
fun DeveloperTypeSurvey() {
    Column(

        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row() {
                val state = remember { mutableStateOf(false) }
                RadioButton(selected = false, onClick = { state.value = !state.value })
                Text(text = "Android", modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
        Card(modifier = Modifier.wrapContentSize()) {
            Row() {
                val state = remember { mutableStateOf(false) }
                RadioButton(selected = false, onClick = { state.value = !state.value })
                Text(text = "Android")
            }
        }
        Card(modifier = Modifier.wrapContentSize()) {
            Row() {
                val state = remember { mutableStateOf(false) }
                RadioButton(selected = false, onClick = { state.value = !state.value })
                Text(text = "Android")
            }
        }
        Card(modifier = Modifier.wrapContentSize()) {
            Row() {
                val state = remember { mutableStateOf(false) }
                RadioButton(selected = false, onClick = { state.value = !state.value })
                Text(text = "Android")
            }
        }
    }

}

@Preview
@Composable
fun DeveloperTypeSurveyPreview() {
    DeveloperTypeSurvey()
}