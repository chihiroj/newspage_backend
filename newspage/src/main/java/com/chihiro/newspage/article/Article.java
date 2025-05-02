package com.chihiro.newspage.article;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import com.chihiro.newspage.user.User;
import java.util.UUID;

@Data
@Entity
public class Article {
    @Id
    private UUID id;


    @Column
    private String title;
    @Column
    private String contents;
    @Column
    private String img_url;

    @ManyToOne
    private User user;
}
