package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.Post;
import com.bgeneral.graphql.forum.model.dto.CreatePostInputDTO;
import com.bgeneral.graphql.forum.repository.PostRepository;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

/**
 * Esta clase controla las peticiones de mutaciones sobre las publicaciones.
 */
@Controller
public class PostsMutationsResolver {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostsMutationsResolver(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    /**
     * Este metodo se mapea contra la mutacion de publicaciones declarada en el esquema para crear una publicacion.
     *
     * @param input Datos de entrada para crear la publicacion.
     * @return Publicacion.
     */
    @SchemaMapping(typeName = "PostsMutations", field = "createPost")
    public Post createPost(@Argument CreatePostInputDTO input) {
        final Post post = new Post();
        post.setUser(userRepo.findById(input.userId()).orElseThrow());
        post.setTitle(input.title());
        post.setBody(input.body());
        post.setTags(input.tags());
        post.setUpvotes(0);
        post.setDownvotes(0);
        return postRepo.save(post);
    }

    /**
     * Este metodo se mapea contra la mutacion de publicaciones declarada en el esquema para eliminar una publicacion.
     *
     * @param id Id de la publicacion.
     * @return Boleano que indica que la publicacion fue eliminado.
     */
    @SchemaMapping(typeName = "PostsMutations", field = "deletePost")
    public Boolean deletePost(@Argument Integer id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Este metodo se mapea contra la mutacion de publicaciones declarada en el esquema para votar una publicacion.
     *
     * @param id Id de la publicacion.
     * @param upvote Indica si el voto es a favor.
     * @return Publicacion.
     */
    @SchemaMapping(typeName = "PostsMutations", field = "votePost")
    public Post votePost(@Argument Integer id, @Argument Boolean upvote) {
        final Post post = postRepo.findById(id).orElseThrow();
        upvote = upvote != null ? upvote : false;
        post.setUpvotes(post.getUpvotes() + (upvote ? 1 : 0));
        post.setDownvotes(post.getDownvotes() + (upvote ? 0 : 1));
        return postRepo.save(post);
    }
}