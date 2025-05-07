package com.chihiro.newspage.article;

import com.chihiro.newspage.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/article")
@CrossOrigin(origins = "*")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> addArticle(@RequestBody @Valid ArticleDTO articleDTO){
        User user = userService.getUserByEmail(articleDTO.getEmail(), articleDTO.getName());
        articleService.addArticle(articleDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("")
    public ResponseEntity<?> getAllArticle(){
        return articleService.getAllArticle();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable UUID id){
        articleService.deleteArticle(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
