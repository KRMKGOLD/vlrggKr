package kr.co.cotton.news.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.co.cotton.news.NewsRoute

const val newsRoute = "news_route"

fun NavGraphBuilder.newsScreen() {
    composable(route = newsRoute) {
        NewsRoute()
    }
}
