interface Attachment {
    val type: String
}


class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo = Photo()
): Attachment{

}
class Photo(
    val id: Int = 0,
    val owner_id: Int = 0,
    val photo_130: String = "",
    val photo_604: String = ""
)

class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio = Audio()
): Attachment{

}
class Audio(
    val id: Int = 0,
    val owner_id: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
    val url: String = ""
)

class VideoAttachment(
    override val type: String = "video",
    val video: Video = Video()
): Attachment{

}
class Video(
    val id: Int = 0,
    val owner_id: Int = 0,
    val title: String = "",
    val descriprion: String = "",
    val duration: Int = 0
)

class DocAttachment(
    override val type: String = "doc",
    val doc: Doc = Doc()
): Attachment{

}
class Doc(
    val id: Int = 0,
    val owner_id: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val url: String = "",
    val type: Int = 1
)

class GraffitiAttachment(
    override val type: String = "graffiti",
    val graffiti: Graffiti = Graffiti()
): Attachment{

}
class Graffiti(
    val id: Int = 0,
    val owner_id: Int = 0,
    val photo_130: String = "",
    val photo_604: String = ""
)