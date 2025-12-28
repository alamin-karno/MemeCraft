package com.fluttx.memecraft.editor.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fluttx.memecraft.core.presentation.MemeTemplate
import com.fluttx.memecraft.core.theme.MemeCraftTheme
import com.fluttx.memecraft.editor.presentation.components.MemeTextBox
import memecraft.composeapp.generated.resources.Res
import memecraft.composeapp.generated.resources.meme_template_01
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MemeEditorRoot(
    template: MemeTemplate,
    viewModel: MemeEditorViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MemeEditorScreen(
        template = template,
        state = state,
        onAction = viewModel::onAction
    )
}


@Composable
fun MemeEditorScreen(
    template: MemeTemplate,
    state: MemeEditorState,
    onAction: (MemeEditorAction) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(template.drawable),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null,
        )

        state.memeTexts.forEach {
            MemeTextBox(
                memeText = it,
                textBoxInteractionState = state.textBoxInteractionState,
                maxHeight = 500.dp,
                maxWidth = 500.dp,
                onClick = {
                    onAction(MemeEditorAction.OnSelectMemeText(it.id))
                },
                onDoubleClick = {
                    onAction(MemeEditorAction.OnEditMemeText(it.id))
                },
                onTextChange = { newText ->
                    onAction(MemeEditorAction.OnMemeTextChange(id= it.id, text = newText))
                },
                onDeleteClick = {
                    onAction(MemeEditorAction.OnDeleteMemeTextClick(id = it.id))
                },
            )
        }

    }
}


@Preview
@Composable
private fun Preview() {
    MemeCraftTheme {
        MemeEditorScreen(
            template = MemeTemplate(
                id = "meme_template_01",
                drawable = Res.drawable.meme_template_01,
            ),
            state = MemeEditorState(),
            onAction = {}
        )
    }
}