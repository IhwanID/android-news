package id.ihwan.gitsnews.feature.headline

data class News(
    var status: String = "" ,
    var totalResults: Int = 0,
    val articles: List<Articles>

){
    data class Articles(
        val source: Source = Source(),
        var author: String? = "",
        var title: String? = "",
        var description: String? = "",
        var url: String? = "",
        var urlToImage: String? = "",
        var publishedAt: String? = "",
        var content: String? = ""
    ){
        data class Source(
            var id: Int = 0,
            var name: String = ""
        )
    }
}