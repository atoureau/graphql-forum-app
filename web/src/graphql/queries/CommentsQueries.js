import { gql } from '@apollo/client';

export const MOST_POPULAR_COMMENTS = gql`
    query MostPopularComments($postId: Int!, $page: Int = 0, $size: Int = 3) {
        comments {
            mostPopularComments(postId: $postId, page: $page, size: $size) {
                id
                post {
                    id
                }
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