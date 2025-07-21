package com.bgeneral.graphql.forum.controller;

import com.bgeneral.graphql.forum.resolver.CommentsMutationsResolver;
import com.bgeneral.graphql.forum.resolver.PostsMutationsResolver;
import com.bgeneral.graphql.forum.resolver.UsersMutationsResolver;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

/**
 * Este controlador recibe las peticiones de mutacion y las rutea hacia su resolvedor correspondiente.
 */
@Controller
public class MutationController {
    private final UsersMutationsResolver usersMutationsResolver;
    private final PostsMutationsResolver postsMutationsResolver;
    private final CommentsMutationsResolver commentsMutationsResolver;

    public MutationController(UsersMutationsResolver usersMutationsResolver, PostsMutationsResolver postsMutationsResolver, CommentsMutationsResolver commentsMutationsResolver) {
        this.usersMutationsResolver = usersMutationsResolver;
        this.postsMutationsResolver = postsMutationsResolver;
        this.commentsMutationsResolver = commentsMutationsResolver;
    }

    /**
     * Este metodo se mapea contra la mutacion de usuarios declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de mutacion deseada.
     *
     * @return Controlador que resuelve las mutaciones de usuarios.
     */
    @MutationMapping
    public UsersMutationsResolver users() {
        return usersMutationsResolver;
    }

    /**
     * Este metodo se mapea contra la mutacion de publicaciones declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de mutacion deseada.
     *
     * @return Controlador que resuelve las mutaciones de publicaciones.
     */
    @MutationMapping
    public PostsMutationsResolver posts() {
        return postsMutationsResolver;
    }

    /**
     * Este metodo se mapea contra la mutacion de comentarios declarada en el esquema e invoca a su respectivo
     * controlador para resolver la solicitud de mutacion deseada.
     *
     * @return Controlador que resuelve las mutaciones de comentarios.
     */
    @MutationMapping
    public CommentsMutationsResolver comments() {
        return commentsMutationsResolver;
    }
}