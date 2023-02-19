package com.axdar.edandroid.screens.error

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axdar.edandroid.R
import com.axdar.edandroid.ui.theme.EdAndroidTheme

@Preview
@Composable
fun ErrorViewPreview() {
    val context = LocalContext.current
    EdAndroidTheme {
        ErrorView(
            title = stringResource(id = R.string.error_header),
            errorCode = "AA-31",
            onReportClicked = {
                Toast.makeText(context, "Support contact click", Toast.LENGTH_SHORT).show()
            },
            onRetryClicked = {
                Toast.makeText(context, "Click button refresh", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Composable
fun ErrorView(
    title: String,
    errorCode: String,
    onReportClicked: () -> Unit,
    onRetryClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxSize()) {
        ErrorDescription(
            title = title,
            errorCode = errorCode,
            onReportClicked = onReportClicked,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        ButtonComponent(
            buttonLabel = stringResource(id = R.string.refresh),
            iconId = R.drawable.ic_refresh,
            onClick = onRetryClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        )
    }

}