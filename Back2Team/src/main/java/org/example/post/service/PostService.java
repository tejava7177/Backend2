package org.example.post.service;




import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.post.domain.Article;
import org.example.post.dto.add;
import org.example.post.dto.update;
import org.example.post.repository.postRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final postRepo postRepository;

    //생성
    public Article save(add request) {
        return postRepository.save(request.toEntity());
    }

    //전체 조회
    public List<Article> findAll() {
        return postRepository.findAll();
    }

    //하나 조회
    public Article findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
    }

    //삭제
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    //수정
    @Transactional
    public Article update(long id, update request) {
        Article article = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}