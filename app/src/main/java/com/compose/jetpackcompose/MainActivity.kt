package com.compose.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.compose.jetpackcompose.ui.theme.JetpackComposeTheme
import com.compose.jetpackcompose.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserGuidePopupPreview()
        }
    }
}
@Composable
fun UserGuidePopup() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(1f)
                .background(Color.White),
            colors = ButtonDefaults.buttonColors(Purple40)
        ) {

            Text(text = "취소")
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(2f)
                .background(Color.White),
            colors = ButtonDefaults.buttonColors(Purple40)
        ) {
            Text(text = "확인")
        }
    }
}
@Preview("default", "round")
@Composable
fun UserGuidePopupPreview() {
    JetpackComposeTheme {
        UserGuidePopup()
    }
}
