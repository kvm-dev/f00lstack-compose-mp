package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.icons.CloseIcon
import ru.kvmsoft.base.ui.icons.SearchIcon
import ru.kvmsoft.base.ui.theme.InputBorder
import ru.kvmsoft.base.ui.theme.SimplyBlack
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.TextStyles
import ru.kvmsoft.base.ui.theme.Unfocused

@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    keyword: MutableState<String>,
    placeholderText: String,
    onValueChange: (String) -> Unit
) {
    val shape = RoundedCornerShape(10.dp)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape)
            .border(1.dp, InputBorder, shape)
            .background(SimplyWhite)

    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = keyword.value,
            onValueChange = onValueChange,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = SimplyWhite,
                focusedTextColor = SimplyBlack,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = SimplyBlack,
                focusedPlaceholderColor = InputBorder,
                focusedLeadingIconColor = SimplyBlack,
                focusedTrailingIconColor = SimplyBlack,

                unfocusedContainerColor = SimplyWhite,
                unfocusedTextColor = InputBorder,
                unfocusedIndicatorColor = SimplyBlack,
                unfocusedPlaceholderColor = InputBorder,

                disabledTextColor = InputBorder,
                disabledContainerColor = Unfocused
            ),
            leadingIcon = { Icon(imageVector = SearchIcon, contentDescription = "search") },
            trailingIcon = {
                Icon(imageVector = CloseIcon,
                    contentDescription = "close",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                        .clickable {
                            keyword.value = ""
                        }) },
            placeholder = {
                Text(
                modifier = modifier,
                text = placeholderText,
                textAlign = TextAlign.Start,
                style = TextStyles.placeholderStyle(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            ) }
        )
    }
}