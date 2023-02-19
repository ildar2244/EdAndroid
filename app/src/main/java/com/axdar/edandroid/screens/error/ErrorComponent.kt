package com.axdar.edandroid.screens.error

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axdar.edandroid.R
import com.axdar.edandroid.ui.theme.EdAndroidTheme

@Preview
@Composable
fun ErrorDescriptionPreview() {
    EdAndroidTheme {
        ErrorDescription(
            title = stringResource(id = R.string.error_header),
            errorCode = "AA-31",
            onReportClicked = { /*TODO*/ })
    }
}

@Composable
fun ErrorDescription(
    title: String,
    errorCode: String,
    onReportClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        ErrorImage()
        HeadingText(text = title)
        TextWithBoldSuffix(
            prefix = stringResource(id = R.string.error_code_prefix),
            suffix = errorCode
        )
        ContactSupportText(onContactClicked = onReportClicked)
    }
}

@Composable
fun ErrorImage() {
    Image(
        painter = painterResource(id = R.drawable.error_img),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .clip(RoundedCornerShape(percent = 25))
            .border(
                BorderStroke(
                    width = 8.dp,
                    color = MaterialTheme.colors.primary
                ),
                RoundedCornerShape(percent = 25)
            )
    )
}

@Composable
fun HeadingText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TextWithBoldSuffix(
    prefix: String,
    suffix: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
            append(prefix)
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(suffix)
            pop(0)
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun ContactSupportText(
    onContactClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val annotatedString = buildAnnotatedString {
        append("Seeing this message too often?\n")
        append("Contact ") //OR append(stringResource(id = R.string. ...))
        withStyle(
            SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )
        ) {
            withAnnotation(tag = "help_tag", annotation = "www.site.com/help") {
                append("tech support")
            }
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations("help_tag", offset, offset)
                .firstOrNull()
                ?.let { annotation ->
                    annotation.item //www.site.com/help
                    onContactClicked()
                }
        },
        style = TextStyle.Default.merge(
            TextStyle(textAlign = TextAlign.Center)
        ),
        modifier = modifier
    )
}
