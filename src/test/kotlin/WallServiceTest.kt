import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest(){
        WallService.clear()
    }

    @Test
    fun add(){
        val comment1 = Post.Comments(1, true)
        val post1 = Post(0, 2, 1, "16.09.23", "Hello", comment1, Post.Likes())

        assertTrue(WallService.add(post1).id != 0)
    }

    @Test
    fun updateExistingPost() {
        val comment1 = Post.Comments(1, true)
        val comment2 = Post.Comments(2, false)
        val post1 = Post(0, 2, 1, "16.09.23", "Hello", Post.Comments(), Post.Likes())
        val post2 = Post(0, 1, 2, "20.09.23", "Hello", comment1, Post.Likes(user_likes = true))
        val post3 = Post(0, 2, 2, "20.09.23", "Time for fun", comment2, Post.Likes())

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val post4 = Post(2, 0, 1, "21.10.23", "Goodbye", comment2, Post.Likes())

        val result = WallService.update(post4)
        assertTrue(result)
    }

    @Test
    fun updateMissingPost() {
        val comment1 = Post.Comments(1, true)
        val comment2 = Post.Comments(2, false)
        val post1 = Post(0, 2, 1, "16.09.23", "Hello", comment1, Post.Likes())
        val post2 = Post(0, 1, 2, "20.09.23", "Hello", comment1, Post.Likes(user_likes = true))
        val post3 = Post(0, 2, 2, "20.09.23", "Time for fun", comment2, Post.Likes(user_likes = true))

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val post4 = Post(10, 0, 1, "21.10.23", "Goodbye", comment2, Post.Likes())

        val result = WallService.update(post4)
        assertFalse(result)
    }
}