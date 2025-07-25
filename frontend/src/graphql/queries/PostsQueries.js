import { gql } from '@apollo/client';

export const MOST_POPULAR_POSTS = gql`
    query MostPopularPosts($page: Int = 0, $size: Int = 5) {
        posts {
            mostPopularPosts(page: $page, size: $size) {
                id
                title
                body
                upvotes
                downvotes
                user {
                    id
                    firstName
                    lastName
                }
            }
        }
    }
`;

export const POSTS_COMMENTS_COUNT = gql`
    query PostsCommentsCount($postId: Int!) {
        posts {
            commentsCount(postId: $postId)
        }
    }
`;