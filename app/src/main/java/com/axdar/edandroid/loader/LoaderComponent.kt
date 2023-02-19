package com.axdar.edandroid.loader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axdar.edandroid.R
import com.axdar.edandroid.ui.theme.EdAndroidTheme

@Preview
@Composable
private fun LoaderComponentPreview() {
    EdAndroidTheme {
        LoaderComponent(Modifier.fillMaxSize())
        /*LoaderComponent(
            Modifier.size(width = 200.dp, height = 400.dp),
            useTransparentBackground = true
        )*/
//        LoaderComponentWithoutSurface()
    }
}

@Composable
private fun LoaderComponent(
    modifier: Modifier = Modifier,
    useTransparentBackground: Boolean = false
) {
    Surface(
        color = if (useTransparentBackground) {
            Color.Black.copy(alpha = 0.3f)
        } else {
            MaterialTheme.colors.surface
        },
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
            Text(
                text = stringResource(R.string.loader_text),
                style = MaterialTheme.typography.caption,
                fontSize = 20.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(all = 32.dp)
            )
        }
    }
}

@Composable
private fun LoaderComponentWithoutSurface(
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
        Text(
            text = stringResource(R.string.loader_text),
            style = MaterialTheme.typography.caption,
            fontSize = 20.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(all = 32.dp)
        )
    }
}