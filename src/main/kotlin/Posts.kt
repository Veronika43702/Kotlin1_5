data class Post(
    val id: Int,
    val date: String,
    val text: String?,
    val reply_owner_id: Int = 0,
    val reply_post_id: Int = 0,
    val owner_id: Int = 0,
    val from_id: Int = 0,
    val created_by: Int = 0,
    val friends_only: Boolean = false,
    val comments: Comments? = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val post_type: String = "post",
    val attachemnts: Array<Attachment> = emptyArray(),
    val geo: Geo? = Geo(),
    val signer_id: Int = 0,
    val copy_history: Array<Post> = emptyArray(),
    val can_pin: Boolean = true,
    val can_delete: Boolean = true,
    val can_edit: Boolean = true,
    val is_pinned: Boolean = false,
    val marked_as_ads: Boolean = false,
    val is_favourite: Boolean = false,
    val donut: Donut = Donut(),
    val postponed_id: Int = 0
) {
    data class Comments(
        val count: Int = 0,
        val can_post: Boolean = true
    )

    data class Copyright(
        val id: Int = 0,
        val link: String = "http",
        val name: String = "",
        val type: String = ""
    )

    data class Likes(
        val count: Int = 0,
        val user_likes: Boolean = false,
        val can_like: Boolean = false,
        val can_publish: Boolean = false
    )

    data class Reposts(
        val count: Int = 0,
        val user_reposts: Boolean = false
    )

    data class Views(
        val count: Int = 0,
    )

    data class Geo(
        val type: String = "",
        val coordinates: String = "",
        val place: String = ""
    )

    data class Donut(
        val is_donat: Boolean = false,
        val paid_duration: Int = 0,
        val can_publish_free_copy: Boolean = true,
        val edit_mode: String = "All"
    )
}