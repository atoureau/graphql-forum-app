import React from 'react';

export default function VoteButtons({ onUpvote, onDownvote }) {
    return (
        <div style={styles.container}>
            <button style={styles.voteBtn} onClick={onUpvote}>👍</button>
            <button style={styles.voteBtn} onClick={onDownvote}>👎</button>
        </div>
    );
}

const styles = {
    container: {
        marginBottom: '0.5rem'
    },
    voteBtn: {
        fontSize: '1.2rem',
        marginRight: '0.5rem',
        padding: '0.2rem 0.5rem',
        cursor: 'pointer',
        border: '1px solid #ccc',
        borderRadius: '4px',
        backgroundColor: '#fff'
    }
};