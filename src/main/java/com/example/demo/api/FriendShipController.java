package com.example.demo.api;

import com.example.demo.bll.models.dtos.FriendShipDTO;
import com.example.demo.bll.models.forms.FriendShipForm;
import com.example.demo.bll.services.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friendships")
@RequiredArgsConstructor
public class FriendShipController {

    private final FriendShipService friendShipService;
    @PostMapping
    public ResponseEntity<FriendShipDTO> createComment(@RequestBody FriendShipForm form) {
        return ResponseEntity.ok(friendShipService.addOne(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FriendShipDTO> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(friendShipService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<FriendShipDTO>> getAllComments() {
        return ResponseEntity.ok(friendShipService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FriendShipDTO> updateComment(@PathVariable Long id, @RequestBody FriendShipForm form) {
        return ResponseEntity.ok(friendShipService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FriendShipDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(friendShipService.delete(id));
    }
}