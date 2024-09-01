package org.example.post.controller;


import lombok.RequiredArgsConstructor;
import org.example.post.domain.Article;
import org.example.post.dto.add;
import org.example.post.dto.response;
import org.example.post.dto.update;
import org.example.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")               //설명
public class PostApiController {

    private final PostService postService;

    @PostMapping("posts")
    public ResponseEntity<Article> addArticle(@RequestBody @Validated add request) {
        Article savedArticle = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("articles")
    public ResponseEntity<List<response>> findAllArticles() {
        List<response> articles = postService.findAll()
                .stream()
                .map(response::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("articles/{id}")
    public ResponseEntity<response> findArticle(@PathVariable long id) {
        Article article = postService.findById(id);

        return ResponseEntity.ok()
                .body(new response(article));
    }

    @DeleteMapping("articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        postService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody update request) {
        Article updatedArticle = postService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}