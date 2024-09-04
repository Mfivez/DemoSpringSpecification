package com.example.demo.api;

import com.example.demo.bll.models.dtos.PostDTO;
import com.example.demo.bll.models.forms.PostForm;
import com.example.demo.bll.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createComment(@RequestBody PostForm form) {
        return ResponseEntity.ok(postService.addOne(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllComments() {
        return ResponseEntity.ok(postService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updateComment(@PathVariable Long id, @RequestBody PostForm form) {
        return ResponseEntity.ok(postService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(postService.delete(id));
    }
}
