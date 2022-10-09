class Comments (
    val count: Int = 0,
    val canPost: Boolean = true,
    val groopsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
        )

data class Post (
    val id: Int = 1,
    val fromId: Int = 2,
    val text: String = "Something written",
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val postType: String = "Post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val isFavourite: Boolean = false,
    val markedAsAds: Boolean = false
        )


object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post.copy(id = post.id + 1)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == index) {
                posts[index] = post.copy()
            }

        }
        return true
    }
}
