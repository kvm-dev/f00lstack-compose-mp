package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.icons.BooksIcon
import ru.kvmsoft.base.ui.icons.EventsIcon
import ru.kvmsoft.base.ui.res.strings.getSubMenuBooks
import ru.kvmsoft.base.ui.res.strings.getSubMenuEvents
import ru.kvmsoft.base.ui.res.strings.getSubMenuStudy
import ru.kvmsoft.base.ui.theme.MainSubNavigationBackground
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain


@Composable
fun MainScreenSubNavigationBlock(
    onClickEvents: () -> Unit,
    onClickBooks: () -> Unit,
    onClickStudy: () -> Unit,
    lang: CurrentLanguageDomain) {
    Row(
        modifier = Modifier
            .padding(top = 22.dp, start = 10.dp, end = 10.dp, bottom = 34.dp)
            .fillMaxWidth()
            .background(MainSubNavigationBackground, RoundedCornerShape(24)),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(percent = 24))
            .clickable{
                onClickEvents()
            }
            .weight(1f)
            .align(Alignment.CenterVertically)
            .padding(horizontal = 18.dp, vertical = 16.dp)){
            Icon(
                imageVector = EventsIcon,
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            NotificationTitle(getSubMenuEvents(lang), modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        Column(modifier = Modifier
            .clip(RoundedCornerShape(percent = 24))
            .clickable{
                onClickBooks()
            }
            .weight(1f)
            .align(Alignment.CenterVertically)
            .padding(horizontal = 18.dp, vertical = 16.dp)){
            Icon(
                imageVector = BooksIcon,
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            NotificationTitle(getSubMenuBooks(lang), modifier = Modifier.align(Alignment.CenterHorizontally))
        }
        Column(modifier = Modifier
            .clip(RoundedCornerShape(percent = 24))
            .clickable{
                onClickStudy()
            }
            .weight(1f)
            .align(Alignment.CenterVertically)
            .padding(horizontal = 18.dp, vertical = 16.dp)){
            Icon(
                imageVector = BooksIcon,
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            NotificationTitle(getSubMenuStudy(lang), modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }

}