package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.painterResource
import ru.kvmsoft.base.ui.ComposeResources.Res
import ru.kvmsoft.base.ui.ComposeResources.logo_fs
import ru.kvmsoft.base.ui.theme.MainGreyLight
import ru.kvmsoft.base.ui.theme.getFoolStackTypography
import ru.kvmsoft.base.ui.utils.decodeBase64ToBitmap
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.kvmsoft.base.ui.icons.mainIcon
import ru.kvmsoft.base.ui.icons.notFoundConnectionIcon
import ru.kvmsoft.base.ui.icons.settingsIcon
import ru.kvmsoft.base.ui.theme.MainGreenLight
import ru.kvmsoft.base.ui.theme.SimplyWhite


@Composable
fun MainScreenHeader(onClickUser: () -> Unit, onClickSettings: ()->Unit, onClickConnectionNotFound: ()-> Unit, userIcon: String, userName: String, lang: CurrentLanguageDomain, isConnectionAvailable: Boolean) {
    val interactionAvatar = remember { MutableInteractionSource() }
    val interactionNoFoundConnection = remember { MutableInteractionSource() }
    val optimizedUserName: String = if(userName == "No-name" && lang == CurrentLanguageDomain.RU){ "Ноунейм" }
    else{
        userName
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(shape = CircleShape),
                contentAlignment = Alignment.Center
        ) {
            if (userIcon.isNotEmpty()) {
                userIcon.decodeBase64ToBitmap()?.let {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        bitmap = it,
                        contentDescription = "Avatar"
                    )
                }
            } else {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable(
                        interactionSource = interactionAvatar,
                        indication = ripple(
                            bounded = true,
                            radius = 24.dp,
                            color = MainGreenLight
                        ),
                        onClick = { onClickUser() }
                    ),
                    painter = painterResource(Res.drawable.logo_fs),
                    contentDescription = "Avatar",
                )
            }
        }
        Text(text = optimizedUserName,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp)
                .clickable(
                    interactionSource = interactionAvatar,
                    indication = ripple(
                        bounded = true,
                        radius = 24.dp,
                        color = MainGreenLight
                    ),
                    onClick = { onClickUser() }
                ),
            style = getFoolStackTypography().headlineSmall,
            color = SimplyWhite,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        if(!isConnectionAvailable){
            Icon(
                tint = Color.Unspecified,
                imageVector = notFoundConnectionIcon,
                contentDescription = "settings",
                modifier = Modifier
                    .size(40.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 12.dp, bottom = 4.dp)
                    .clickable(
                        interactionSource = interactionNoFoundConnection,
                        indication = ripple(
                            bounded = true,
                            radius = 24.dp,
                            color = MainGreenLight
                        ),
                        onClick = { onClickConnectionNotFound() }
                    )
            )
        }
        SettingsButton(onClick = onClickSettings)
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewMainScreenHeader() {
    MainScreenHeader(
        onClickUser = {},
        onClickSettings = {},
        onClickConnectionNotFound = {},
        userIcon = "",
        userName = "UserName",
        isConnectionAvailable = false,
        lang = CurrentLanguageDomain.EN
    )
}