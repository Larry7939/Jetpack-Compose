package com.compose.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.jetpackcompose.ui.theme.JetpackComposeTheme
import com.compose.jetpackcompose.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInScreenPreview()
        }
    }
}

@Composable
fun SignInScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "One Market",
            fontSize= 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Purple40)) {
            Text(text = "로그인")
        }
    }
}

@Preview("default", "round")
@Composable
fun SignInScreenPreview() {
    JetpackComposeTheme {
        SignInScreen()
    }
}
