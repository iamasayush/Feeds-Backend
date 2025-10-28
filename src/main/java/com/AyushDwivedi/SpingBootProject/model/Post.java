package com.AyushDwivedi.SpingBootProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private User user;
}
