package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import ru.kvmsoft.base.ui.theme.BottomSheetBackground


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NonDismissibleBottomSheet(
    onDismissRequest: () -> Unit,
    contentBottomSheet: @Composable (ColumnScope.() -> Unit)
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { newState ->
            newState != SheetValue.Hidden // Prevent dismissal when trying to hide
        }
    )

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = bottomSheetState,
        content = contentBottomSheet,
        containerColor = BottomSheetBackground
    )
}