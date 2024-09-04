package com.example.demo.api;

import com.example.demo.bll.models.dtos.CommentDTO;
import com.example.demo.bll.models.forms.CommentForm;
import com.example.demo.bll.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentForm form) {
        return ResponseEntity.ok(commentService.addOne(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentForm form) {
        return ResponseEntity.ok(commentService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.delete(id));
    }
}