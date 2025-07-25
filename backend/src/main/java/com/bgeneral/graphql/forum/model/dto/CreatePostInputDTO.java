package com.bgeneral.graphql.forum.model.dto;

import java.util.List;

/**
 * Clase que modela los datos de entrada para crear a una publicacion.
 *
 * @param title Titulo.
 * @param body Cuerpo.
 * @param userId Id del usuario.
 * @param tags Lista de etiquetas.
 */
public record CreatePostInputDTO (
    String title,
    String body,
    Integer userId,
    List<String> tags
) {}