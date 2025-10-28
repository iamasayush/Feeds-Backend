package com.AyushDwivedi.SpingBootProject.controller;

import com.AyushDwivedi.SpingBootProject.model.Post;
import com.AyushDwivedi.SpingBootProject.repository.PostRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostRepository postRepo;

    @GetMapping
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postRepo.save(post);
    }
}
