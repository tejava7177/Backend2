package org.example.post.dto;



import lombok.Getter;
import org.example.post.domain.Article;

@Getter
public class response {

    private final String title;
    private final String content;

    public response(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}