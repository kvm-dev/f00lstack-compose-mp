package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kvmsoft.base.ui.theme.MainDark
import ru.kvmsoft.base.ui.theme.MainError
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.Unfocused
import ru.kvmsoft.base.ui.theme.getFoolStackTypography

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onChange: (String) -> Unit,
    isError: Boolean,
    errorMessage: String,
    isEnabled: Boolean,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            enabled = isEnabled,
            value = value,
            onValueChange = {
                if (!it.contains("\n"))
                    onChange(it)
            },
            placeholder = {
                Text(text = placeholder,
                    style = getFoolStackTypography().bodyMedium,
                    color = Unfocused)
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = SimplyWhite,
                unfocusedBorderColor = Unfocused,
                focusedTextColor = MainDark,
                focusedBorderColor = Unfocused,
                errorBorderColor = MainError,
                cursorColor = MainDark
            ),
            shape = RoundedCornerShape(8.dp),
            isError = isError
        )
        if (isError){
            Text(
                text = errorMessage,
                style = getFoolStackTypography().bodySmall,
                fontSize = 16.sp,
                color = MainError,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}