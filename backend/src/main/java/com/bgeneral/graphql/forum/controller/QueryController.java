package com.bgeneral.graphql.forum.controller;

import com.bgeneral.graphql.forum.resolver.CommentsQueriesResolver;
import com.bgeneral.graphql.forum.resolver.PostsQueriesResolver;
import com.bgeneral.graphql.forum.resolver.UsersQueriesResolver;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * Esta clase controla las peticiones de queries para rutearlas hacia su resolvedor correspondiente.
 */
@Controller
public class QueryController {
    private final UsersQueriesResolver usersQueriesResolver;
    private final PostsQueriesResolver postsQueriesResolver;
    private final CommentsQueriesResolver commentsQueriesResolver;

    public QueryController(UsersQueriesResolver usersQueriesResolver, PostsQueriesResolver postsQueriesResolver, CommentsQueriesResolver commentsQueriesResolver) {
        this.usersQueriesResolver = usersQueriesResolver;
        this.postsQueriesResolver = postsQueriesResolver;
        this.commentsQueriesResolver = commentsQueriesResolver;
    }

    /**
     * Este metodo se mapea contra el query de usuarios declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de query deseada.
     *
     * @return Controlador que resuelve los queries de usuarios.
     */
    @QueryMapping
    public UsersQueriesResolver users() {
        return usersQueriesResolver;
    }

    /**
     * Este metodo se mapea contra el query de publicaciones declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de query deseada.
     *
     * @return Controlador que resuelve los queries de publicaciones.
     */
    @QueryMapping
    public PostsQueriesResolver posts() {
        return postsQueriesResolver;
    }

    /**
     * Este metodo se mapea contra el query de comentarios declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de query deseada.
     *
     * @return Controlador que resuelve los queries de comentarios.
     */
    @QueryMapping
    public CommentsQueriesResolver comments() {
        return commentsQueriesResolver;
    }
}