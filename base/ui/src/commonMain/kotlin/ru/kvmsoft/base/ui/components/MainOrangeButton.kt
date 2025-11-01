package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kvmsoft.base.ui.theme.DisabledButtonBackground
import ru.kvmsoft.base.ui.theme.MainOrangeLight
import ru.kvmsoft.base.ui.theme.SimplyWhite
import ru.kvmsoft.base.ui.theme.Unfocused

@Composable
fun MainOrangeButton(onClick: () -> Unit, text: String, isEnabled: Boolean = true, isLoading: Boolean = false, modifier: Modifier) {
    if(!isLoading){
        val colors = if(isEnabled){
            ButtonDefaults.buttonColors(
                containerColor = MainOrangeLight,
                contentColor = SimplyWhite
            )
        }
        else{
            ButtonDefaults.buttonColors(
                containerColor = DisabledButtonBackground,
                contentColor = Unfocused
            )
        }
        Button(
            onClick = { if(isEnabled){ onClick() } },
            colors = colors,
            modifier = modifier,
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = text)
        }
    }
    else{
        LoadingIndicator(modifier = Modifier.padding(20.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainOrangeButton() {
    MainOrangeButton(text = "SomethingText", isEnabled = true, onClick = {}, modifier = Modifier.fillMaxWidth())
}