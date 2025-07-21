package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.User;
import com.bgeneral.graphql.forum.model.dto.CreateUserInputDTO;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UsersMutationsResolver {
    private final UserRepository userRepo;

    public UsersMutationsResolver(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

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