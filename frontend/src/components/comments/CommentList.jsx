import React from 'react';
import {CommentCard} from '../comments';

export default function CommentList({ comments, onVote }) {
    if (!comments?.length) {
        return <p style={styles.empty}>No hay comentarios para mostrar.</p>;
    }

    return (
        <div style={styles.list}>
            {comments.map(comment => (
                <CommentCard
                    key={comment.id}
                    comment={comment}
                    onVote={onVote}
                />
            ))}
        </div>
    );
}

const styles = {
    list: {
        display: 'flex',
        flexDirection: 'column',
        gap: '1rem'
    },
    empty: {
        fontSize: '0.9rem',
        color: '#999',
        marginTop: '0.5rem'
    }
};