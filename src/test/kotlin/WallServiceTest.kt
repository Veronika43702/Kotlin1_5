import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest(){
        val service = WallService()
        service.clear()
    }

    @Test
    fun add(){
        val service = WallService()
        val comments1 = Post.Comments(1, true)
        val post1 = Post(0, "20.09.23", "Hello", comments = comments1, likes = Post.Likes(user_likes = true))

        assertTrue(service.add(post1).id != 0)
    }

    @Test
    fun updateExistingPost() {
        val service = WallService()
        val comments1 = Post.Comments(1, true)
        val comments2 = Post.Comments(2, false)
        val post1 = Post(0,  "16.09.23", "Hello")
        val post2 = Post(0, "20.09.23", "Hello", comments = comments1, likes = Post.Likes(user_likes = true))
        val post3 = Post(0, "20.09.23", "Time for fun")


        service.add(post1)
        service.add(post2)
        service.add(post3)

        val post4 = Post(2, "21.10.23", "Goodbye", comments = comments2)

        val result = service.update(post4)
        assertTrue(result)
    }

    @Test
    fun updateMissingPost() {
        val service = WallService()
        val comments1 = Post.Comments(1, true)
        val comments2 = Post.Comments(2, false)
        val post1 = Post(0,  "16.09.23", "Hello")
        val post2 = Post(0, "20.09.23", "Hello", comments = comments1, likes = Post.Likes(user_likes = true))
        val post3 = Post(0, "20.09.23", "Time for fun")


        service.add(post1)
        service.add(post2)
        service.add(post3)

        val post4 = Post(100, "21.10.23", "Goodbye", comments = comments2)

        val result = service.update(post4)
        assertFalse(result)
    }

    @Test
    fun creatingComment(){
        val service = WallService()

        val post1 = Post(0,  "16.09.23", "Hello")
        val post2 = Post(0, "20.09.23", "Hello")
        val post3 = Post(0, "20.09.23", "Time for fun")

        service.add(post1)
        service.add(post2)
        service.add(post3)

        val comment = Comment(1)
        val result = service.createComment(2, comment)
        assertEquals(comment, result)

    }

    @Test(expected = ObjectNotFoundException::class)
    fun creatingCommentFailDuePostNotFound(){
        val service = WallService()

        val post1 = Post(0,  "16.09.23", "Hello")
        service.add(post1)
        val comment = Comment(1)
        service.createComment(100, comment)
    }

    @Test
    fun reportCreationSuccessFull(){
        val service = WallService()
        service.add(Post(0, "", ""))
        println(service.createComment(1, Comment(1)))
        val report = Report(comment_id = 1, reason = 1)
        assertEquals("Найден негативный комментарий, жалоба: " + report , service.reportsOfNegativeComment(report))
    }
    @Test(expected = ReasonForReportNotExist::class)
    fun reportFailDueReasonNotFound(){
        val service = WallService()
        service.add(Post(0, "", ""))
        println(service.createComment(1, Comment(1)))
        val report = Report(comment_id = 1, reason = 100)
        service.reportsOfNegativeComment(report)
    }

    @Test(expected = ObjectNotFoundException::class)
    fun reportFailDueCommentNotFound(){
        val service = WallService()
        val report = Report(comment_id = 100)
        service.reportsOfNegativeComment(report)
    }
}