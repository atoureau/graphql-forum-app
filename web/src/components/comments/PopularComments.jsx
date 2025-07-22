import React from 'react';
import { useQuery, useMutation } from '@apollo/client';
import {Spinner} from "../shared";
import {CommentList} from '../comments';
import { MOST_POPULAR_COMMENTS } from '../../graphql/queries';
import { VOTE_COMMENT } from '../../graphql/mutations';

export default function PopularComments({ postId }) {
    const { loading, error, data, refetch } = useQuery(MOST_POPULAR_COMMENTS, {
        variables: { postId }
    });

    const [voteComment] = useMutation(VOTE_COMMENT, {
        onCompleted: () => refetch(),
        onError: (err) => console.error("Error al votar comentario", err.message)
    });

    const handleVoteComment = (commentId, isUpvote) => {
        voteComment({ variables: { commentId, upvote: isUpvote } });
    };

    if (loading) return <Spinner message="Cargando comentarios populares..." />;
    if (error) return <p style={styles.status}>Error al cargar comentarios</p>;

    return (
        <div style={styles.container}>
            <h4 style={styles.title}>Comentarios populares</h4>
            <CommentList
                comments={data?.comments.mostPopularComments}
                onVote={handleVoteComment}
            />
        </div>
    );
}

const styles = {
    container: { marginTop: '1rem' },
    title: { fontSize: '1.1rem', marginBottom: '0.5rem' },
    status: { fontSize: '0.9rem', color: '#888' }
};