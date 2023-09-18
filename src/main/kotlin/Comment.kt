data class Comment(
    val id: Int = 0,
    val from_id: Int = 0,
    val date: String = "",
    val text: String = "",
    val donut: Donut = Donut(),
    val reply_to_user: Int = 0,
    val reply_to_comment: Int = 0,
    val attachemnts: Array<Attachment> = emptyArray(),
    val parents_stack: Array<String> = emptyArray(),
    val thread: Thread = Thread(),
) {
    data class Donut(
        val is_don: Boolean = false,
        val placeholder: String = ""
    )

    data class Thread(
        val count: Int = 0,
        val can_post: Boolean = false,
        val show_reply_button: Boolean = false,
        val groups_can_post: Boolean = false
    )
}

data class Report(
    val owner_id: Int = 0,
    val comment_id: Int = 0,
    val reason: Int = 0,
)