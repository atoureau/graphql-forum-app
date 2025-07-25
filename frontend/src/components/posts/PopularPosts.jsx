import React, { useState } from 'react';
import { useQuery, useMutation } from '@apollo/client';
import {PostList} from '../posts';
import {PaginationControls, Spinner} from '../shared';
import { MOST_POPULAR_POSTS } from '../../graphql/queries';
import { VOTE_POST } from '../../graphql/mutations';

export default function PopularPosts() {
    const [page, setPage] = useState(0);

    const { loading, error, data, refetch } = useQuery(MOST_POPULAR_POSTS, {
        variables: { page }
    });

    const [votePost] = useMutation(VOTE_POST, {
        onCompleted: () => refetch(),
        onError: (err) => console.error("Voto fallido", err.message)
    });

    const handleVote = (postId, isUpvote) => {
        votePost({ variables: { postId, upvote: isUpvote } });
    };

    const handlePrev = () => {
        if (page > 0) {
            const newPage = page - 1;
            setPage(newPage);
            refetch({ page: newPage });
        }
    };

    const handleNext = () => {
        const newPage = page + 1;
        setPage(newPage);
        refetch({ page: newPage });
    };

    if (loading) return <Spinner message="Cargando publicaciones populares..." />;
    if (error) return <p style={styles.error}>Error: {error.message}</p>;

    return (
        <div style={styles.container}>
            <h1 style={styles.heading}>🔥Top Publicaciones</h1>
            <PostList posts={data.posts.mostPopularPosts} onVote={handleVote} />
            <PaginationControls page={page} onPrev={handlePrev} onNext={handleNext} />
        </div>
    );
}

const styles = {
    container: { maxWidth: '700px', margin: '2rem auto', padding: '0 1rem' },
    heading: { textAlign: 'center', fontSize: '2rem', marginBottom: '2rem' },
    loading: { textAlign: 'center', marginTop: '2rem' },
    error: { color: 'red', textAlign: 'center', marginTop: '2rem' }
};