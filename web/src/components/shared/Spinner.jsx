import React from 'react';

export default function Spinner({ message = 'Cargando...' }) {
    return (
        <div style={styles.container}>
            <div style={styles.spinner}></div>
            <p style={styles.text}>{message}</p>
        </div>
    );
}

const styles = {
    container: {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        margin: '2rem auto'
    },
    spinner: {
        width: '40px',
        height: '40px',
        border: '5px solid #eee',
        borderTop: '5px solid #007bff',
        borderRadius: '50%',
        animation: 'spin 1s linear infinite'
    },
    text: {
        marginTop: '1rem',
        fontSize: '1rem',
        color: '#666'
    }
};