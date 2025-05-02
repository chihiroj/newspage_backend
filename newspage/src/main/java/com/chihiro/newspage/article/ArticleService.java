package com.chihiro.newspage.article;

import com.chihiro.newspage.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void addArticle(ArticleDTO articleDTO, User user) {
       Article article = new Article();

       article.setId(UUID.randomUUID());
       article.setUser(user);
       article.setContents(articleDTO.getContents());
       article.setTitle(articleDTO.getTitle());
       article.setImg_url(articleDTO.getImgUrl());
       articleRepository.save(article);
    }

    public ResponseEntity<?> getAllArticle() {
        List<Article> articles = articleRepository.findAll();

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    public void deleteArticle(UUID id) {
        Optional<Article> articleToDelete = articleRepository.findById(id);

        if(articleToDelete.isEmpty()) {
            throw new RuntimeException("The article does not exist.");
        } else {
            articleRepository.deleteById(id);
        }
    }
}
