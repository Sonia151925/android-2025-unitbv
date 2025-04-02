package com.cst.cstacademy2025unitbv.models

enum class MediaType(val id: Int) {
    PODCAST(0),
    VIDEO(1),
    POST(2)
}

sealed class MediaModel(
    val type: MediaType
)


class PodcastModel(
    val title:String
) : MediaModel(MediaType.PODCAST)
class VideoModel(
    val title:String,
    val description:String
) : MediaModel(MediaType.VIDEO)
class PostModel(
    val title:String,
    val imageUrl:String
) : MediaModel(MediaType.POST)