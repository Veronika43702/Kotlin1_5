import java.lang.RuntimeException

class WallService {
    private var id: Int = 1
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<Report>()

    // добавление комментария в массив при наличии поста с указанным ID
    fun createComment(postId: Int, comment: Comment): Comment {
        val isIdFound = posts.find {
            it.id == postId
        }

        if (isIdFound != null) {
            comments += comment
            return comments.last()
        } else throw ObjectNotFoundException("No post with $postId")
    }

    fun reportsOfNegativeComment(report: Report): String {
        val maxReasonNumber = 8
        if (report.reason !in 0..maxReasonNumber) {
            throw ReasonForReportNotExist()
        }

        val isComment_idFound = comments.find {
            it.id == report.comment_id
        }

        if (isComment_idFound != null) {
            reports += report
            return "Найден негативный комментарий, жалоба: " + report
        } else throw ObjectNotFoundException("No comment with id = ${report.comment_id} ")
    }

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
//    val service = WallService()
//
//    val attachment1 = PhotoAttachment()
//    val attachment2 = AudioAttachment()
//    val attachment = arrayOf(attachment1, attachment2)
//    val comment1 = Post.Comments(1, true)
//    val comment2 = Post.Comments(2, false)
//
//    val post1 = Post(0,  "16.09.23", "Hello")
//    val post2 = Post(0, "20.09.23", "Hello")
//    val post3 = Post(0, "20.09.23", "Time for fun")
//
//    //добавление постов
//    service.add(post1)
//    service.add(post2)
//    service.add(post3)
//
//    val comment = Comment(1)
//    println(service.createComment(1, comment))
//    val report = Report(comment_id = 1, reason = 1)
//    println(service.reportsOfNegativeComment(report))

//
//    // вывод постов
//    service.printPosts()
//    // обновление постов
//    val post4 = Post(2, "21.10.23", "Goodbye", comments = comment1)
//    val post5 = Post(100, "10.10.23", "Goodbye")
//    println(service.update(post4))
//    println(service.update(post5))
//
//    // вывод обновленного массива
//    service.printPosts()
}