package ru.kvmsoft.features.main.imp.mapper

import ru.kvmsoft.base.ui.model.AchievementItem
import ru.kvmsoft.base.ui.model.Chip
import ru.kvmsoft.base.ui.model.EventItem
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.features.events.api.model.EventDomain
import ru.kvmsoft.features.profile.api.model.AchievementDomain

object Mapper {
    fun List<EventDomain>.mapToEventsItems(): List<EventItem>{
        val list = ArrayList<EventItem>()
        if(this.isNotEmpty()){
            this.forEach {  event->
                val tags = ArrayList<Chip>()
                event.eventSubs.forEach { sub->
                    tags.add(Chip(id = sub.subId, name = sub.subName))
                }
                list.add(EventItem(
                    eventId = event.eventId,
                    eventName = event.eventName,
                    eventStartDate = event.eventDateStart.timestampToDateString(),
                    eventImageBase64 = event.eventImageBase64,
                    eventCost = event.eventCost,
                    eventDescription = event.eventDescription,
                    eventTags = tags
                ))
            }
        }
        return list
    }

    fun List<AchievementDomain>.mapToAchievementsItems(): List<AchievementItem>{
        val list = ArrayList<AchievementItem>()
        if(this.isNotEmpty()){
            this.forEach {  achieve->
                list.add(AchievementItem(
                    achievementId = achieve.achievementId,
                    achievementName = achieve.achievementName,
                    achievementDescription = achieve.achievementDescription,
                    achievementLevel = achieve.achievementLevel
                ))
            }
        }
        return list
    }
}