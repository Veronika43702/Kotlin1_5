import javax.swing.text.StyledEditorKit.BoldAction
import Attachment as Attachment

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

object WallService {
    private var id: Int = 1
    private var posts = emptyArray<Post>()

    // добавление поста с id +1 от последнего поста
    fun add(post: Post): Post {
        val postWithNewId = post.copy(id = id)
        id += 1
        posts += postWithNewId
        return posts.last()

    }

    // обновление поста по id (вывод false, если поста нет)
    fun update(post: Post): Boolean {
        for ((index, postInPosts) in posts.withIndex()) {
            if (postInPosts.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun printPosts() {
        println(posts.contentToString())
    }

    fun clear() {
        posts = emptyArray()
        id = 1
    }
}

fun main(args: Array<String>) {
//    val attachment1 = PhotoAttachment()
//    val attachment2 = AudioAttachment()
//    val attachment = arrayOf(attachment1, attachment2)
//    val comment1 = Post.Comments(1, true)
//    val comment2 = Post.Comments(2, false)
//
//    val post1 = Post(0, "16.09.23", "Hello", comments = comment1, attachemnts = attachment)
//    val post2 = Post(0, "20.09.23", "Hello", comments = comment2, likes = Post.Likes(user_likes = true))
//    val post3 = Post(0, "20.09.23", "Time for fun")
//
//    //добавление постов
//    WallService.add(post1)
//    WallService.add(post2)
//    WallService.add(post3)
//
//    // вывод постов
//    WallService.printPosts()
//    // обновление постов
//    val post4 = Post(2, "21.10.23", "Goodbye", comments = comment1)
//    val post5 = Post(100, "10.10.23", "Goodbye")
//    println(WallService.update(post4))
//    println(WallService.update(post5))
//
//    // вывод обновленного массива
//    WallService.printPosts()
}