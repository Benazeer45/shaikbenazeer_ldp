package com.springboot.onetomany_bi.specifications;

import com.springboot.onetomany_bi.entity.Post;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecifications {

    public static Specification<Post> isPublished(Boolean published) {
        return (root, query, criteriaBuilder) ->
                published == null ? null : criteriaBuilder.equal(root.get("published"), published);
    }

    public static Specification<Post> hasTitleContaining(String title) {
        return (root, query, criteriaBuilder) ->
                title == null || title.isEmpty()
                        ? null
                        : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }
}
