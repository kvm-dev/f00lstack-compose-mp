package ru.kvmsoft.features.news.imp.mapper

import ru.kvmsoft.base.storage.model.New
import ru.kvmsoft.base.storage.model.News
import ru.kvmsoft.base.ui.model.NewsItem
import ru.kvmsoft.features.news.api.model.NewsDomain
import ru.kvmsoft.features.news.api.model.SingleNewsDomain
import ru.kvmsoft.features.news.imp.model.NewResponse

object Mapper {

    fun map(response: NewResponse): SingleNewsDomain {
        return SingleNewsDomain(
            newsId = response.newsId,
            newsName = response.newsName,
            newsText = response.newsText,
            newsDate = response.newsDate,
            newsLink = response.newsLink,
            newsImageBase64 = response.newsImage)
    }

    fun map(response: News): NewsDomain {
        val newsList = ArrayList<SingleNewsDomain>()
        response.news.forEach { new->
            newsList.add(
                SingleNewsDomain(
                    newsId = new.newsId,
                    newsName = new.newsName,
                    newsDate = new.newsDate,
                    newsText = new.newsText,
                    newsLink = new.newsLink,
                    newsImageBase64 = new.newsImageBase64
                )
            )
        }
        return NewsDomain(
            news = newsList,
            errorMsg = response.errorMsg
        )
    }

    fun map(response: NewsDomain):News{
        val newsList = ArrayList<New>()
        response.news.forEach { new->
            newsList.add(New(
                newsId = new.newsId,
                newsName = new.newsName,
                newsDate = new.newsDate,
                newsText = new.newsText,
                newsLink = new.newsLink,
                newsImageBase64 = new.newsImageBase64
            ))
        }
        return News(
            news = newsList,
            errorMsg = response.errorMsg
        )
    }

    fun mapToNewsItems(news: NewsDomain): List<NewsItem>{
        val newsList = HashSet<NewsItem>()
        news.news.forEach { newsItem->
            newsList.add(NewsItem(
                newsId = newsItem.newsId,
                newsName = newsItem.newsName,
                newsText = newsItem.newsText,
                newsDate = newsItem.newsDate,
                newsLink = newsItem.newsLink,
                newsImageBase64 = newsItem.newsImageBase64
            ))
        }
        return newsList.toList()
    }
}