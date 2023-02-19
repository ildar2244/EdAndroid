package com.axdar.edandroid.screens.error

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axdar.edandroid.R
import com.axdar.edandroid.ui.theme.EdAndroidTheme

@Preview
@Composable
fun ButtonComponentPreview() {
    EdAndroidTheme {
        ButtonComponent(
            buttonLabel = stringResource(id = R.string.refresh),
            iconId = R.drawable.ic_refresh
        ) {

        }
    }
}

@Composable
fun ButtonComponent(
    buttonLabel: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int? = null,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(percent = 50),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buttonLabel,
                modifier = Modifier.weight(1f)
            )
            iconId?.let {
                Icon(painter = painterResource(id = iconId), contentDescription = null)
            }
        }
    }
}
