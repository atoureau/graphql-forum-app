import React from 'react';
import { useQuery } from '@apollo/client';
import {Spinner} from "../shared";
import { POSTS_COMMENTS_COUNT } from '../../graphql/queries';

export default function CommentsCount({ postId }) {
    const { data, loading, error } = useQuery(POSTS_COMMENTS_COUNT, {
        variables: { postId }
    });

    if (loading) return <Spinner message="Cargando cantidad de comentarios..." />;
    if (error) return <p style={{ ...styles.meta, color: 'red' }}>Error al cargar comentarios</p>;

    return (
        <p style={styles.meta}>
            Comentarios: <strong>{data?.posts.commentsCount ?? 0}</strong>
        </p>
    );
}

const styles = {
    meta: {
        fontSize: '0.9rem',
        color: '#666',
        marginBottom: '0.5rem'
    }
};