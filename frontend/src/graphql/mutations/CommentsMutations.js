import { gql } from "@apollo/client";

export const VOTE_COMMENT = gql`
    mutation VoteComment($commentId: Int!, $upvote: Boolean) {
        comments {
            voteComment(id: $commentId, upvote: $upvote) {
                id
                post {
                    id
                }
                upvotes
                downvotes
            }
        }
    }
`;