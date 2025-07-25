package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.User;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Esta clase controla las peticiones de queries sobre los usuarios.
 */
@Controller
public class UsersQueriesResolver {
    private final UserRepository userRepo;

    public UsersQueriesResolver(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Este metodo se mapea contra el query de usuarios declarado en el esquema para consultar la
     * lista de usuarios.
     *
     * @return lista de usuarios.
     */
    @SchemaMapping(typeName = "UsersQueries", field = "users")
    public List<User> users() {
        return userRepo.findAll();
    }
}