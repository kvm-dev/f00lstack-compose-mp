package ru.kvmsoft.features.events.imp.mapper

import ru.kvmsoft.base.storage.model.Event
import ru.kvmsoft.base.storage.model.EventSub
import ru.kvmsoft.base.storage.model.Events
import ru.kvmsoft.base.ui.model.Chip
import ru.kvmsoft.base.ui.model.EventItem
import ru.kvmsoft.base.ui.model.EventsItemState
import ru.kvmsoft.base.ui.model.UiState
import ru.kvmsoft.base.ui.utils.timestampToDateString
import ru.kvmsoft.features.events.api.model.EventDomain
import ru.kvmsoft.features.events.api.model.EventSubDomain
import ru.kvmsoft.features.events.api.model.EventsDomain
import ru.kvmsoft.features.events.imp.model.EventResponse

object Mapper {

    fun map(response: EventResponse): EventDomain {
        val subs = ArrayList<EventSubDomain>()
        response.eventSubs.forEach { sub->
            subs.add(EventSubDomain(
                subId = sub.subId,
                subName = sub.subName
            ))
        }
        return EventDomain(
            eventId = response.eventId,
            eventName = response.eventName,
            eventDescription = response.eventDescription,
            eventDateStart = response.eventDateStart,
            eventCost = response.eventCost,
            eventImageBase64 = response.eventImage,
            eventRefLink = response.eventRefLink,
            eventSubs =  subs
        )
    }

    fun map(eventsList: List<Event>): List<EventDomain>{
        val events = ArrayList<EventDomain>()
        eventsList.forEach { event->
            events.add(map(event))
        }
        return events
    }

    private fun map(event: Event): EventDomain{
        val subs = ArrayList<EventSubDomain>()
        event.eventSubs.forEach { sub->
            subs.add(EventSubDomain(
                subId = sub.subId,
                subName = sub.subName
            ))
        }
        return EventDomain(
            eventId = event.eventId,
            eventName = event.eventName,
            eventDescription = event.eventDescription,
            eventCost = event.eventCost,
            eventRefLink = event.eventRefLink,
            eventDateStart = event.eventDateStart,
            eventImageBase64 = event.eventImageBase64,
            eventSubs = subs
        )
    }

    fun map(eventsDomain: EventsDomain): Events {
        val events = ArrayList<Event>()
        eventsDomain.events.forEach { event->
            val subs = ArrayList<EventSub>()
            event.eventSubs.forEach { sub->
                subs.add(EventSub(
                    subId = sub.subId,
                    subName = sub.subName
                ))
            }
            events.add(Event(
                eventId = event.eventId,
                eventName = event.eventName,
                eventDescription = event.eventDescription,
                eventDateStart = event.eventDateStart,
                eventCost = event.eventCost,
                eventRefLink = event.eventRefLink,
                eventImageBase64 = event.eventImageBase64,
                eventSubs = subs
            ))
        }
        return Events(
            events = events,
            errorMsg = "")
    }

    private fun mapToEventChip(sub: EventSubDomain): Chip {
        return Chip(
            id = sub.subId,
            name = sub.subName
        )
    }

//    fun mapToChips(eventList: List<EventDomain>): List<Chip>{
//        val list = HashSet<Chip>()
//        eventList.forEach { event->
//            event.eventSubs.forEach {sub->
//                list.add(mapToEventChip(sub))
//            }
//        }
//        return list.toList()
//    }

    fun mapToChips(eventsState: UiState<EventsItemState>, isAsMode: Boolean): List<Chip>{
        val list = HashSet<Chip>()
        if (eventsState is UiState.Success){
                if(isAsMode){
                    eventsState.data?.events?.filter { it.eventCost == 0 }?.forEach { event->
                        event.eventTags.forEach { sub->
                            list.add(sub)
                        }
                    }
                }
                else{
                    eventsState.data?.events?.forEach { event->
                        event.eventTags.forEach { sub->
                            list.add(sub)
                        }
                    }
                }
        }
        return list.toList()
    }

    fun mapToEventItems(eventsDomain: EventsDomain?): List<EventItem>{
        val eventList = ArrayList<EventItem>()
        eventsDomain?.events?.forEach {event->
            val tags = ArrayList<Chip>()
            event.eventSubs.forEach {
                tags.add(Chip(it.subId, it.subName))
            }
            eventList.add(
                EventItem(
                    eventId = event.eventId,
                    eventName = event.eventName,
                    eventStartDate = event.eventDateStart.timestampToDateString(),
                    eventImageBase64 = event.eventImageBase64,
                    eventTags = tags,
                    eventDescription = event.eventDescription,
                    eventCost = event.eventCost
                )
            )
        }
        return eventList
    }

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
}