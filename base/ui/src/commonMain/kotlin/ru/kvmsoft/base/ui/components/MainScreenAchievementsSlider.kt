package ru.kvmsoft.base.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.kvmsoft.base.ui.icons.achievements.Collocutor
import ru.kvmsoft.base.ui.icons.achievements.Commentator
import ru.kvmsoft.base.ui.icons.achievements.Eternalstudent
import ru.kvmsoft.base.ui.icons.achievements.Foolstaker
import ru.kvmsoft.base.ui.icons.achievements.Ideagenerator
import ru.kvmsoft.base.ui.icons.achievements.Mentor
import ru.kvmsoft.base.ui.icons.achievements.Overachiever
import ru.kvmsoft.base.ui.icons.achievements.Reader
import ru.kvmsoft.base.ui.icons.achievements.Star
import ru.kvmsoft.base.ui.model.AchievementsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.res.strings.getAchievementsNotFound
import ru.kvmsoft.base.ui.utils.noRippleClickable
import ru.kvmsoft.features.language.api.model.CurrentLanguageDomain

@Composable
fun MainScreenAchievementsSlider(
    lang: CurrentLanguageDomain,
    achievementsState: UiState<AchievementsItemState>,
    selectId: MutableState<Int>,
    isShowDialog: MutableState<Boolean>) {
    val currentImageIndex by remember { mutableIntStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(126.dp)) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()) {
            // Scrollable Row of Cards
            when(achievementsState){
                UiState.Loading->{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        horizontalArrangement = Arrangement.Absolute.SpaceBetween
                    ) {
                        repeat(3) {
                            ShimmerEffect(
                                modifier = Modifier
                                    .size(width = 126.dp, height = 100.dp)
                                    .padding(horizontal = 8.dp)
                                    .background(Color.LightGray, RoundedCornerShape(16)),
                                durationMillis = 1000,
                                cornerRadius = 16
                            )
                        }
                    }
                }
                UiState.Empty->{
                        NotificationTitle(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center),
                            text = getAchievementsNotFound(lang)
                        )
                }
                is UiState.Success->{
                    val achievements = achievementsState.data?.achievements?: listOf()
                    println("ачивсайз ${achievements.size}")
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        itemsIndexed(achievements) { index, achievement ->
                            Card(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(16.dp))
                                    .width(126.dp)
                                    .height(100.dp)
                                    .noRippleClickable(
                                        onClick = {
                                                if (index != currentImageIndex && !isAnimating) {
                                                    isAnimating = true
                                                }
                                                selectId.value = achievement.achievementId
                                                isShowDialog.value = true
                                        }
                                    ),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Transparent,
                                )
                            ) {
                                Box {
                                    val icon = when (achievement.achievementId) {
                                        1 -> Foolstaker
                                        2 -> Collocutor
                                        3 -> Commentator
                                        4 -> Mentor
                                        5 -> Reader
                                        6 -> Overachiever
                                        7 -> Ideagenerator
                                        8 -> Eternalstudent
                                        else -> Foolstaker
                                    }

                                    Icon(
                                        imageVector = icon,
                                        tint = Color.Unspecified,// Reference your ImageVector from the .kt file
                                        contentDescription = achievement.achievementDescription,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                    )

                                    Row(modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(top = 2.dp)) {
                                        when (achievement.achievementLevel) {
                                            1 -> {
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp),
                                                )
                                            }

                                            2 -> {
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp)
                                                        .padding(horizontal = 2.dp),
                                                )
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp)
                                                        .padding(horizontal = 2.dp))
                                            }

                                            3 -> {
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp)
                                                        .padding(horizontal = 2.dp))
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp)
                                                        .padding(horizontal = 2.dp))
                                                Icon(
                                                    imageVector = Star, // Reference your ImageVector from the .kt file
                                                    tint = Color.Unspecified,
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(width = 8.dp, height = 8.dp)
                                                        .padding(horizontal = 2.dp))
                                            }

                                            else -> {
                                                //nothing
                                            }
                                        }
                                    }
                                    NotificationTitle(
                                        modifier = Modifier
                                            .align(Alignment.BottomCenter)
                                            .padding(bottom = 20.dp),
                                        text = achievement.achievementName
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}