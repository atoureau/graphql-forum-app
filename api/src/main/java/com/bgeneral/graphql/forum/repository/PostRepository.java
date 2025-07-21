package com.bgeneral.graphql.forum.repository;

import com.bgeneral.graphql.forum.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Override
    @NonNull
    Page<Post> findAll(@NonNull Pageable pageable);

    @Query("""
    select p
    from Post p
    order by (p.upvotes - p.downvotes) desc, p.id asc
""")
    Page<Post> findMostPopular(Pageable pageable);
}
