package com.fluttx.memecraft

import androidx.compose.runtime.Composable
import com.fluttx.memecraft.core.presentation.NavigationRoot
import com.fluttx.memecraft.core.theme.MemeCraftTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MemeCraftTheme {
        NavigationRoot()
    }
}