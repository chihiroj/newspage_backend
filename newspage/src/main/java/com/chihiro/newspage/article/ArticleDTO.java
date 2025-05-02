package com.chihiro.newspage.article;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ArticleDTO {
    private String title;
    private String contents;
    private String imgUrl;
    private String name;
    private String email;
}
