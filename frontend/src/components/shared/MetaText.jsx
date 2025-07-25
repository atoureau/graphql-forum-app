import React from 'react';

export default function MetaText({ label, value }) {
    return (
        <p style={defaultStyle}>
            {label}: <strong>{value}</strong>
        </p>
    );
}

const defaultStyle = {
    fontSize: '0.9rem',
    color: '#666',
    marginBottom: '0.5rem'
};