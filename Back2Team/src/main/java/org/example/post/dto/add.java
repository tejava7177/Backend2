package org.example.post.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.post.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class add {

    @NotBlank
    @Size(min=1, max=5)
    private String title;
    @Email
    private String content;
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}