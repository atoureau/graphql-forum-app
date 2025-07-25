package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.User;
import com.bgeneral.graphql.forum.model.dto.CreateUserInputDTO;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

/**
 * Esta clase controla las peticiones de mutaciones sobre los usuarios.
 */
@Controller
public class UsersMutationsResolver {
    private final UserRepository userRepo;

    public UsersMutationsResolver(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Este metodo se mapea contra la mutacion de usuarios declarada en el esquema para crear un usuario.
     *
     * @param input Datos de entrada para crear el usuario.
     * @return Usuario.
     */
    @SchemaMapping(typeName = "UsersMutations", field = "createUser")
    public User createUser(@Argument CreateUserInputDTO input) {
        final User user = new User();
        user.setFirstName(input.firstName());
        user.setSecondName(input.secondName());
        user.setLastName(input.lastName());
        user.setSecondLastName(input.secondLastName());
        user.setMarriedLastName(input.marriedLastName());
        return userRepo.save(user);
    }
}