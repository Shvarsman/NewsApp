package com.shvarsman.news.domain.repository

import android.adservices.topics.Topic
import com.shvarsman.news.domain.entity.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getAllSubscriptions(): Flow<List<String>>

    suspend fun addSubscription(topic: String)

    suspend fun updateArticlesForTopic(topic: String)

    suspend fun removeSubscription(topic: String)

    suspend fun updateArticlesForAllSubscriptions()

    fun getArticlesByTopic(topic: List<String>): Flow<List<Article>>

    suspend fun clearAllArticles(topic: List<String>)
}