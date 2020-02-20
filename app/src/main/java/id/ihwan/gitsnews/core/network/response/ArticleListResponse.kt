package id.ihwan.gitsnews.core.network.response

import id.ihwan.gitsnews.feature.home.model.Articles

data class ArticleListResponse(
    var status: String = "" ,
    var totalResults: Int = 0,
    val articles: List<Articles>
)