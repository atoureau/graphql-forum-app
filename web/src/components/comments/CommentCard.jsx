import React from 'react';
import {MetaText} from '../shared';
import {VoteButtons} from '../shared';

export default function CommentCard({ comment, onVote }) {
    return (
        <div style={styles.card}>
            <MetaText label="By" value={comment.user.firstName + ' ' + comment.user.lastName } />

            <MetaText label="Popularidad" value={comment.upvotes - comment.downvotes} />

            <VoteButtons
                onUpvote={() => onVote?.(comment.id, true)}
                onDownvote={() => onVote?.(comment.id, false)}
            />

            <p style={styles.body}>{comment.body}</p>
        </div>
    );
}

const styles = {
    card: {
        padding: '1rem',
        border: '1px solid #ddd',
        borderRadius: '8px',
        marginBottom: '1rem',
        boxShadow: '0 2px 5px rgba(0,0,0,0.05)',
        backgroundColor: '#fff'
    },
    author: {
        fontSize: '0.9rem',
        color: '#666',
        marginBottom: '0.3rem'
    },
    body: {
        fontSize: '1rem',
        lineHeight: '1.4',
        marginTop: '0.5rem'
    }
};