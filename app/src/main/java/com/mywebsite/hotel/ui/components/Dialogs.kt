package com.mywebsite.hotel.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.mywebsite.hotel.R

@Composable
fun AlertDialogPattern(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector? = null,
    confirmText: String = stringResource(R.string.ok),
    dismissText: String = stringResource(R.string.no),
    confirmButtonExists: Boolean = false,
    dismissButtonExists: Boolean = false
) {
    AlertDialog(
        icon = { if (icon != null) Icon(icon, contentDescription = "Example Icon") },
        title = { Text(text = dialogTitle) },
        text = { Text(
            text = dialogText,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            if (confirmButtonExists) {
                TextButton(
                    onClick = {
                        onConfirmation()
                    }
                ) {
                    Text(confirmText)
                }
            }
        },
        dismissButton = {
            if (dismissButtonExists) {
                TextButton(
                    onClick = { onDismissRequest() }
                ) {
                    Text(dismissText)
                }
            }
        }
    )
}

//@Composable
//fun ToastCompose(text: String) {
//    val context = LocalContext.current
//    Column(
//        content = {
//            Button(onClick = {
//                Toast.makeText(
//                    context,
//                    text,
//                    Toast.LENGTH_LONG
//                ).show()
//            }, content = {
//                Text(text = "Show Toast")
//            })
//        }, modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    )
//}