import React from 'react';
import { useQuery } from '@apollo/client';
import { GET_MOST_POPULAR_COMMENTS } from '../graphql/CommentQueries';

export default function PopularComments({ postId }) {
    const { loading, error, data } = useQuery(GET_MOST_POPULAR_COMMENTS, {
        variables: { postId }
    });

    if (loading) return <p style={styles.loading}>Cargando comentarios…</p>;
    if (error) return <p style={styles.error}>Error: {error.message}</p>;

    return (
        <div style={styles.commentContainer}>
            <h3 style={styles.commentTitle}>💬 Top Comentarios</h3>
            {data.comments.mostPopularComments.map(comment => (
                <div key={comment.id} style={styles.commentCard}>
                    <p style={styles.content}>{comment.body}</p>
                    <p style={styles.author}>
                        By {comment.user.firstName} {comment.user.lastName} (Usuario ID: {comment.user.id})
                    </p>
                    <p style={styles.score}>Score: {comment.upvotes - comment.downvotes}</p>
                </div>
            ))}
        </div>
    );
}

const styles = {
    commentContainer: {
        marginTop: '1rem',
        paddingTop: '1rem',
        borderTop: '1px solid #eee'
    },
    commentTitle: {
        fontSize: '1.2rem',
        marginBottom: '0.5rem',
        color: '#444'
    },
    commentCard: {
        backgroundColor: '#f9f9f9',
        padding: '0.75rem',
        borderRadius: '6px',
        marginBottom: '0.75rem',
        border: '1px solid #ddd'
    },
    commentBody: {
        margin: 0,
        fontSize: '0.95rem'
    },
    score: {
        fontSize: '0.85rem',
        color: '#666',
        marginTop: '0.4rem'
    },
    loading: {
        fontSize: '0.9rem',
        color: '#999'
    },
    error: {
        color: 'red'
    }
};