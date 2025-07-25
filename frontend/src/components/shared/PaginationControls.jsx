import React from 'react';

export default function PaginationControls({ page, onNext, onPrev }) {
    return (
        <div style={styles.pagination}>
            <button style={styles.button} onClick={onPrev} disabled={page === 0}>
                ◀ Anterior
            </button>
            <span style={styles.pageNumber}>Página {page + 1}</span>
            <button style={styles.button} onClick={onNext}>
                Siguiente ▶
            </button>
        </div>
    );
}

const styles = {
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
    }
};