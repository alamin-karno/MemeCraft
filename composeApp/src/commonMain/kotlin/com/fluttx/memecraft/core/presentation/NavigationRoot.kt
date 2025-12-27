package com.fluttx.memecraft.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.fluttx.memecraft.editor.presentation.MemeEditorRoot
import com.fluttx.memecraft.gallery.presentation.MemeGalleryScreen

@Composable
fun NavigationRoot() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.MemeGallery,
    ) {
        composable<Route.MemeGallery> {
            MemeGalleryScreen(
                onTemplateSelected = {memeTemplate ->
                    navController.navigate(Route.MemeEditor(memeTemplate.id))
                }
            )
        }
        composable<Route.MemeEditor> { route ->
            val templateId = route.toRoute<Route.MemeEditor>().templateId
            val template = remember (templateId) {
                memeTemplates.first{ it.id == templateId }
            }
            MemeEditorRoot(template = template)
        }
    }
}