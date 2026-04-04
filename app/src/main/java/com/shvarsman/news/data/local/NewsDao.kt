package com.shvarsman.news.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Transaction
import com.shvarsman.news.domain.entity.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsDao {

    @Query("SELECT * FROM subscriptions")
    fun getAllSubscriptions(): Flow<List<SubscriptionDbModel>>

    @Insert(onConflict = IGNORE)
    suspend fun addSubscriptions(subscriptionDbModel: SubscriptionDbModel)

    @Transaction
    @Delete
    suspend fun deleteSubscriptions(subscriptionDbModel: SubscriptionDbModel)

    @Query("SELECT * FROM articles WHERE topic in (:topics) ORDER BY publishedAt DESC")
    fun getAllArticlesByTopics(topics: List<String>): Flow<List<ArticleDbModel>>

    @Insert(onConflict = IGNORE)
    suspend fun addArticles(article: List<ArticleDbModel>)

    @Query("DELETE FROM articles WHERE topic in (:topics)")
    suspend fun deleteArticlesByTopics(topics: List<String>)
}