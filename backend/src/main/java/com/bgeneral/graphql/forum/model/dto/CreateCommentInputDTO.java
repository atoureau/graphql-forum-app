package com.bgeneral.graphql.forum.model.dto;

/**
 * Clase que modela los datos de entrada para crear a un comentario.
 *
 * @param body Cuerpo del comentario.
 * @param userId Id del usuario.
 */
public record CreateCommentInputDTO (
    String body,
    Integer userId
) {}