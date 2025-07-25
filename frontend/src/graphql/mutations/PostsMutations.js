import { gql } from "@apollo/client";

export const VOTE_POST = gql`
    mutation VotePost($postId: Int!, $upvote: Boolean) {
        posts {
            votePost(id: $postId, upvote: $upvote) {
                id
                upvotes
                downvotes
            }
        }
    }
`;