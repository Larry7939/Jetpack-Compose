package com.compose.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.jetpackcompose.ui.theme.JetpackComposeTheme
import com.compose.jetpackcompose.ui.theme.Shadow10
import com.compose.jetpackcompose.ui.theme.Shadow4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TitleTextPreview()
        }
    }
}

@Composable
fun TitleText() {
    Row(
        modifier = Modifier.absolutePadding(left=24.dp,right=24.dp).height(100.dp).fillMaxWidth().background(Color.Blue),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Larry",
            color = Shadow4,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = "안드로이드",
            color = Shadow10,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            letterSpacing = 10.sp
        )
        Text(
            text = "안드로이드",
            color = Shadow10,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            letterSpacing = 10.sp
        )
    }
}

@Preview
@Composable
fun TitleTextPreview() {
    JetpackComposeTheme {
        TitleText()
    }
}
