package com.bgeneral.graphql.forum.repository;

import com.bgeneral.graphql.forum.model.Comment;
import com.bgeneral.graphql.forum.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz que define metodos personalizados para ejecutar operaciones en la base de datos
 * sobre la entidad JPA de comentario.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    /**
     * Busca la cantidad de comentarios sobre una publicacion dada.
     *
     * @param postId Id de la publicacion.
     * @return Cantidad de comentarios.
     */
    @Query("""
    select count(c.id)
    from Comment c
    where c.post.id = :postId
""")
    Integer countByPostId(@Param("postId") Integer postId);

    /**
     * Busca los comentarios de una publicacion dada.
     *
     * @param post Publicacion.
     * @param pageable Paginacion.
     * @return Pagina con la lista de comentarios.
     */
    Page<Comment> findByPost(Post post, Pageable pageable);

    /**
     * Busca los comentarios mas populares de una publicacion dada.
     *
     * @param postId Id de la publicacion.
     * @param pageable Paginacion.
     * @return Pagina con la lista de comentarios mas populares.
     */
    @Query("""
    select c
    from Comment c
    where c.post.id = :postId
    order by (c.upvotes - c.downvotes) desc, c.id asc
""")
    Page<Comment> findMostPopularByPostId(@Param("postId") Integer postId, Pageable pageable);
}