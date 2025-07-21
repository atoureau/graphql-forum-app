package com.bgeneral.graphql.forum.resolver;

import com.bgeneral.graphql.forum.model.Post;
import com.bgeneral.graphql.forum.model.dto.CreatePostInputDTO;
import com.bgeneral.graphql.forum.repository.PostRepository;
import com.bgeneral.graphql.forum.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostsMutationsResolver {
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostsMutationsResolver(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

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

    @SchemaMapping(typeName = "PostsMutations", field = "deletePost")
    public Boolean deletePost(@Argument Integer id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @SchemaMapping(typeName = "PostsMutations", field = "votePost")
    public Post votePost(@Argument Integer id, @Argument Boolean upvote) {
        final Post post = postRepo.findById(id).orElseThrow();
        upvote = upvote != null ? upvote : false;
        post.setUpvotes(post.getUpvotes() + (upvote ? 1 : 0));
        post.setDownvotes(post.getDownvotes() + (upvote ? 0 : 1));
        return postRepo.save(post);
    }
}