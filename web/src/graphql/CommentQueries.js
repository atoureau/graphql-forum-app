import { gql } from '@apollo/client';

export const GET_MOST_POPULAR_COMMENTS = gql`
    query GetMostPopularComments($postId: Int!, $page: Int = 0, $size: Int = 3) {
        comments {
            mostPopularComments(postId: $postId, page: $page, size: $size) {
                id
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