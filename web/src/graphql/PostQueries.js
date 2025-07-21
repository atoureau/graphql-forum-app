import { gql } from '@apollo/client';

export const GET_MOST_POPULAR_POSTS = gql`
    query GetMostPopularPosts($page: Int = 0, $size: Int = 5) {
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

export const GET_COMMENTS_COUNT = gql`
    query GetCommentCount($postId: Int!) {
        posts {
            commentsCount(postId: $postId)
        }
    }
`;