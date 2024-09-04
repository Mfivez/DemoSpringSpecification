package com.example.demo.api;

import com.example.demo.bll.models.dtos.LikeDTO;
import com.example.demo.bll.models.forms.LikeForm;
import com.example.demo.bll.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    @PostMapping
    public ResponseEntity<LikeDTO> createComment(@RequestBody LikeForm form) {
        return ResponseEntity.ok(likeService.addOne(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(likeService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<LikeDTO>> getAllComments() {
        return ResponseEntity.ok(likeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikeDTO> updateComment(@PathVariable Long id, @RequestBody LikeForm form) {
        return ResponseEntity.ok(likeService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LikeDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(likeService.delete(id));
    }
}