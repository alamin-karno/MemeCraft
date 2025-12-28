package com.fluttx.memecraft.editor.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.fluttx.memecraft.core.theme.MemeCraftTheme
import com.fluttx.memecraft.editor.presentation.util.rememberFillTextStyle
import com.fluttx.memecraft.editor.presentation.util.rememberStrokeTextStyle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OutlinedImpactText(
    text: String,
    strokeTextStyle: TextStyle,
    fillTextStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = text,
            style = strokeTextStyle,
        )
        Text(
            text = text,
            style = fillTextStyle,
        )
    }
}



@Composable
@Preview
fun OutlinedImpactTextPreview() {
    MemeCraftTheme {
        OutlinedImpactText(
            text = "Hello World",
            strokeTextStyle = rememberStrokeTextStyle(),
            fillTextStyle = rememberFillTextStyle(),
        )
    }
}