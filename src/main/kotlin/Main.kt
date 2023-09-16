import javax.swing.text.StyledEditorKit.BoldAction

data class Post(
    val id: Int,
    val owner_id: Int,
    val from_id: Int,
    val date: String,
    val text: String,
    val comments: Comments,
    val likes: Likes,
    val can_pin: Boolean = true,
    val can_delete: Boolean = true,
    val can_edit: Boolean = true,
) {
    data class Comments(
        val count: Int = 0,
        val can_post: Boolean = true
    )

    data class Likes(
        val count: Int = 0,
        val user_likes: Boolean = false
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
                posts[index] = post.copy(
                    post.id,
                    post.owner_id,
                    post.from_id,
                    post.date,
                    post.text,
                    post.comments,
                    post.likes,
                    post.can_pin,
                    post.can_delete,
                    post.can_edit
                )
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

    fun getPosts(): Array<Post> {
        return posts
    }
}

fun main(args: Array<String>) {
//    val comment1 = Post.Comments(1, true)
//    val comment2 = Post.Comments(2, false)
//    val post1 = Post(0, 2, 1, "16.09.23", "Hello", Post.Comments(), Post.Likes())
//    val post2 = Post(0, 1, 2, "20.09.23", "Hello", comment1, Post.Likes(user_likes = true))
//    val post3 = Post(0, 2, 2, "20.09.23", "Time for fun", comment2, Post.Likes())
//
//    // добавление постов
//    println(WallService.add(post1))
//    println(WallService.add(post2))
//    println(WallService.add(post3))
//
//    // вывод полученного массива
//    println("массив постов:")
//    WallService.printPosts()
//    // обновление постов
//    val post4 = Post(2, 0, 1, "21.10.23", "Goodbye", comment2, Post.Likes())
//    val post5 = Post(10, 0, 1, "10.10.23", "Goodbye", comment1, Post.Likes())
//    println(WallService.update(post4))
//    println(WallService.update(post5))
//    // вывод обновленного массива
//    WallService.printPosts()
}