package com.chihiro.newspage.article;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Data
public class ArticleDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String contents;
    @NotBlank
    @URL
    private String imgUrl;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
}
