package com.bgeneral.graphql.forum.model.dto;

/**
 * Clase que modela los datos de entrada para crear a un usuario.
 *
 * @param firstName Primer nombre.
 * @param secondName Segundo nombre.
 * @param lastName Primer apellido.
 * @param secondLastName Segundo apellido.
 * @param marriedLastName Apellido de casada.
 */
public record CreateUserInputDTO (
    String firstName,
    String secondName,
    String lastName,
    String secondLastName,
    String marriedLastName
) {}