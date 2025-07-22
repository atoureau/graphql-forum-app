import { createRoot } from 'react-dom/client'
import './index.css'
import App from './components/App.jsx'
import { ApolloClient, InMemoryCache, ApolloProvider } from '@apollo/client';

const client = new ApolloClient({
    uri: 'http://localhost:8080/graphql',
    cache: new InMemoryCache({
        typePolicies: {
            Query: {
                fields: {
                    posts: {
                        merge: true
                    },
                    comments: {
                        merge: true
                    }
                }
            },
            PostsQueries: {
                keyFields: false,
                fields: {
                    mostPopularPosts: {
                        keyArgs: ['page', 'size'],
                        merge(incoming) {
                            return incoming;
                        }
                    },
                    commentsCount: {
                        keyArgs: ['postId'],
                        merge(_, incoming) {
                            return incoming;
                        }
                    }
                }
            },
            CommentsQueries: {
                keyFields: false,
                fields: {
                    mostPopularComments: {
                        keyArgs: ['postId', 'page', 'size'],
                        merge(incoming) {
                            return incoming;
                        }
                    }
                }
            }
        }
    })
});

const root = createRoot(document.getElementById('root'));

root.render(
    <ApolloProvider client={client}>
        <App />
    </ApolloProvider>,
);