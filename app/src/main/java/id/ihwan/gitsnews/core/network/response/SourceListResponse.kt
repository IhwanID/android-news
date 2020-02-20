package id.ihwan.gitsnews.core.network.response

import id.ihwan.gitsnews.feature.home.model.Sources

data class SourceListResponse(
    val status: String?,
    val sources: List<Sources>
)