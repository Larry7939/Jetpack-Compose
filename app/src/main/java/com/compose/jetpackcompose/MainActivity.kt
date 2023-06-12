package com.compose.jetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfirmDialogPreview()
        }
    }
}

@Composable
fun ConfirmDialog() {
    AlertDialog(onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "확인")
            }
        },
        dismissButton = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "취소")
            }
        },
        title = {
            Row{
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(Modifier.size(10.dp))
                Text(text = "제목")
            }
        },
        text = { Text(text = "내용") }
    )
}

@Preview("default", "dialog")
@Preview("dark theme", "dialog", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ConfirmDialogPreview() {
    JetpackComposeTheme(dynamicColor = false) {
        ConfirmDialog()
    }
}