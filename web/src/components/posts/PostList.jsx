import React from 'react';
import {PostCard} from '../posts';

export default function PostList({ posts, onVote }) {
    if (!posts?.length) {
        return <p style={styles.empty}>No hay publicaciones para mostrar.</p>;
    }

    return (
        <div style={styles.list}>
            {posts.map(post => (
                <PostCard key={post.id} post={post} onVote={onVote} />
            ))}
        </div>
    );
}

const styles = {
    list: {
        display: 'flex',
        flexDirection: 'column',
        gap: '1.5rem'
    },
    empty: {
        fontSize: '0.9rem',
        color: '#999',
        marginTop: '1rem'
    }
};