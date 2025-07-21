import React, { useState } from 'react';
import { useQuery, useMutation } from '@apollo/client';
import PopularComments from './PopularComments.jsx';
import { GET_MOST_POPULAR_POSTS, GET_COMMENTS_COUNT } from '../graphql/PostQueries';
import { VOTE_POST } from '../graphql/PostMutations';

export default function PopularPosts() {
    const [page, setPage] = useState(0);

    const { loading, error, data, refetch } = useQuery(GET_MOST_POPULAR_POSTS, {
        variables: { page }
    });

    const [votePost] = useMutation(VOTE_POST, {
        onCompleted: () => refetch()
    });

    const handleVote = (postId, isUpvote) => {
        votePost({
            variables: { postId, upvote: isUpvote },
            onCompleted: () => {
                refetch();
            },
            onError: (err) => {
                console.error("Voto fallido", err.message);
            }
        });
    };

    const handlePrev = () => {
        if (page > 0) {
            setPage(prev => {
                const newPage = prev - 1;
                refetch({ page: newPage });
                return newPage;
            });
        }
    };

    const handleNext = () => {
        setPage(prev => {
            const newPage = prev + 1;
            refetch({ page: newPage });
            return newPage;
        });
    };

    if (loading) return <p style={styles.loading}>Cargando publicaciones…</p>;
    if (error) return <p style={styles.error}>Error: {error.message}</p>;

    return (
        <div style={styles.container}>
            <h1 style={styles.heading}>🔥Top Publicaciones</h1>
            {data.posts.mostPopularPosts.map(post => (
                <div key={post.id} style={styles.card}>
                    <h2 style={styles.postTitle}>{post.title}</h2>
                    <p style={styles.meta}>
                        By {post.user.firstName} {post.user.lastName} (Usuario ID: {post.user.id})
                    </p>
                    <p style={styles.meta}>
                        Popularidad: <strong>{post.upvotes - post.downvotes}</strong>
                    </p>

                    <div style={{ marginBottom: '0.5rem' }}>
                        <button style={styles.voteBtn} onClick={() => handleVote(post.id, true)}>👍</button>
                        <button style={styles.voteBtn} onClick={() => handleVote(post.id, false)}>👎</button>
                    </div>

                    <p style={styles.body}>{post.body}</p>

                    <CommentCount postId={post.id} />

                    <PopularComments postId={post.id} />
                </div>
            ))}

            <div style={styles.pagination}>
                <button style={styles.button} onClick={handlePrev} disabled={page === 0}>
                    ◀ Anterior
                </button>
                <span style={styles.pageNumber}>Página {page + 1}</span>
                <button style={styles.button} onClick={handleNext}>
                    Siguiente ▶
                </button>
            </div>
        </div>
    );
}

function CommentCount({ postId }) {
    const { data, loading } = useQuery(GET_COMMENTS_COUNT, {
        variables: { postId }
    });

    if (loading) return <p style={styles.meta}>Cargando cantidad de comentarios...</p>;
    return (
        <p style={styles.meta}>
            Comentarios: <strong>{data?.posts.commentsCount ?? 0}</strong>
        </p>
    );
}

const styles = {
    container: {
        maxWidth: '700px',
        margin: '2rem auto',
        padding: '0 1rem',
        fontFamily: 'system-ui, sans-serif'
    },
    heading: {
        textAlign: 'center',
        fontSize: '2rem',
        marginBottom: '2rem'
    },
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
    meta: {
        fontSize: '0.9rem',
        color: '#666',
        marginBottom: '0.5rem'
    },
    body: {
        fontSize: '1rem',
        lineHeight: '1.5'
    },
    voteBtn: {
        fontSize: '1.2rem',
        marginRight: '0.5rem',
        padding: '0.2rem 0.5rem',
        cursor: 'pointer',
        border: '1px solid #ccc',
        borderRadius: '4px',
        backgroundColor: '#fff'
    },
    pagination: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        gap: '1rem',
        marginTop: '2rem'
    },
    button: {
        padding: '0.5rem 1rem',
        backgroundColor: '#333',
        color: '#fff',
        border: 'none',
        borderRadius: '6px',
        cursor: 'pointer'
    },
    pageNumber: {
        fontSize: '1rem'
    },
    loading: {
        textAlign: 'center',
        marginTop: '2rem'
    },
    error: {
        color: 'red',
        textAlign: 'center',
        marginTop: '2rem'
    }
};