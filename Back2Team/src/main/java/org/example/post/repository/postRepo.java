package org.example.post.repository;


import org.example.post.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepo extends JpaRepository<Article, Long> {

}