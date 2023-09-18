sealed class Attachment(val type: String)


data class PhotoAttachment(
    val photo: Photo = Photo()
) : Attachment("photo") {
    data class Photo(
        val id: Int = 0,
        val owner_id: Int = 0,
        val photo_130: String = "",
        val photo_604: String = ""
    )
}


data class AudioAttachment(
    val audio: Audio = Audio()
) : Attachment("audio") {
    data class Audio(
        val id: Int = 0,
        val owner_id: Int = 0,
        val artist: String = "",
        val title: String = "",
        val duration: Int = 0,
        val url: String = ""
    )
}


data class VideoAttachment(
    val video: Video = Video()
) : Attachment("video") {
    data class Video(
        val id: Int = 0,
        val owner_id: Int = 0,
        val title: String = "",
        val descriprion: String = "",
        val duration: Int = 0
    )
}


data class DocAttachment(
    val doc: Doc = Doc()
) : Attachment("doc") {
    data class Doc(
        val id: Int = 0,
        val owner_id: Int = 0,
        val title: String = "",
        val size: Int = 0,
        val ext: String = "",
        val url: String = "",
        val type: Int = 1
    )
}


class GraffitiAttachment(
    val graffiti: Graffiti = Graffiti()
) : Attachment("graffiti") {
    data class Graffiti(
        val id: Int = 0,
        val owner_id: Int = 0,
        val photo_130: String = "",
        val photo_604: String = ""
    )
}

