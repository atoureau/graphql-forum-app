import React from 'react';
import {MetaText} from '../shared';
import {VoteButtons} from '../shared';
import {PopularComments} from '../comments';
import {CommentsCount} from "../posts";

export default function PostCard({ post, onVote }) {
    return (
        <div style={styles.card}>
            <h2 style={styles.postTitle}>{post.title}</h2>

            <MetaText label="By" value={post.user.firstName + ' ' + post.user.lastName } />

            <MetaText label="Popularidad" value={post.upvotes - post.downvotes} />

            <VoteButtons onUpvote={() => onVote(post.id, true)} onDownvote={() => onVote(post.id, false)} />

            <p style={styles.body}>{post.body}</p>

            <CommentsCount postId={post.id} />

            <PopularComments postId={post.id} />
        </div>
    );
}

const styles = {
    card: {
        border: '1px solid #ddd',
        borderRadius: '8px',
        padding: '1rem',
        marginBottom: '1.5rem',
        boxShadow: '0 2px 5px rgba(0,0,0,0.1)'
    },
    postTitle: {
        margin: 0,
        fontSize: '1.5rem',
        color: '#333'
    },
    body: {
        fontSize: '1rem',
        lineHeight: '1.5'
    }
};