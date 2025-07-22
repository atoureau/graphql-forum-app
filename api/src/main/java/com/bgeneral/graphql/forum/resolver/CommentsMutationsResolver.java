package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.Comment;
import com.bgeneral.graphql.forum.model.dto.CreateCommentInputDTO;
import com.bgeneral.graphql.forum.repository.CommentRepository;
import com.bgeneral.graphql.forum.repository.PostRepository;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

/**
 * Esta clase controla las peticiones de mutaciones sobre los comentarios.
 */
@Controller
public class CommentsMutationsResolver {
    private final CommentRepository commentRepo;
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public CommentsMutationsResolver(CommentRepository commentRepo, PostRepository postRepo, UserRepository userRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    /**
     * Este metodo se mapea contra la mutacion de comentarios declarada en el esquema para crear un comentario.
     *
     * @param postId Id de la publicacion.
     * @param input Datos de entrada para crear el comentario.
     * @return Comentario.
     */
    @SchemaMapping(typeName = "CommentsMutations", field = "createComment")
    public Comment createComment(@Argument Integer postId, @Argument CreateCommentInputDTO input) {
        final Comment comment = new Comment();
        comment.setPost(postRepo.findById(postId).orElseThrow());
        comment.setUser(userRepo.findById(input.userId()).orElseThrow());
        comment.setBody(input.body());
        comment.setUpvotes(0);
        comment.setDownvotes(0);
        return commentRepo.save(comment);
    }

    /**
     * Este metodo se mapea contra la mutacion de comentarios declarada en el esquema para eliminar un comentario.
     *
     * @param postId Id de la publicacion.
     * @param commentId Id del comentario.
     * @return Boleano que indica que el comentario fue eliminado.
     */
    @SchemaMapping(typeName = "CommentsMutations", field = "deleteComment")
    public Boolean deleteComment(@Argument Integer postId, @Argument Integer commentId) {
        return commentRepo.findById(commentId).filter(comment -> comment.getPost().getId().equals(postId)).map(comment -> {
            commentRepo.delete(comment);
            return true;
        }).orElse(false);
    }

    /**
     * Este metodo se mapea contra la mutacion de comentarios declarada en el esquema para votar un comentario.
     *
     * @param id Id del comentario.
     * @param upvote Indica si el voto es a favor.
     * @return Comentario.
     */
    @SchemaMapping(typeName = "CommentsMutations", field = "voteComment")
    public Comment voteComment(@Argument Integer id, @Argument Boolean upvote) {
        final Comment comment = commentRepo.findById(id).orElseThrow();
        upvote = upvote != null ? upvote : false;
        comment.setUpvotes(comment.getUpvotes() + (upvote ? 1 : 0));
        comment.setDownvotes(comment.getDownvotes() + (upvote ? 0 : 1));
        return commentRepo.save(comment);
    }
}