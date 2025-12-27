package com.fluttx.memecraft

import androidx.compose.runtime.Composable
import com.fluttx.memecraft.core.theme.MemeCraftTheme
import com.fluttx.memecraft.gallery.presentation.GalleryScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MemeCraftTheme {
        GalleryScreen(onTemplateSelected = {})
    }
}