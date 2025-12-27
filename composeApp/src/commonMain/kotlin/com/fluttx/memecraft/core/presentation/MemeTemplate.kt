package com.fluttx.memecraft.core.presentation

import memecraft.composeapp.generated.resources.Res
import memecraft.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.DrawableResource

data class MemeTemplate(
    val id: String,
    val drawable: DrawableResource
)

val memeTemplates = Res
    .allDrawableResources
    .filterKeys { it.startsWith("meme_template") }
    .map { (key, value) -> MemeTemplate(id = key, drawable = value) }