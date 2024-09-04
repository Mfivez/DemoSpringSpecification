package com.example.demo.api;

import com.example.demo.bll.models.dtos.UserDTO;
import com.example.demo.bll.models.forms.UserForm;
import com.example.demo.bll.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //POST /users : Créer un nouvel utilisateur.
    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserForm form) {
        return ResponseEntity.ok(userService.addOne(form));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserForm form) {
        return ResponseEntity.ok(userService.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/username")
    public ResponseEntity<List<UserDTO>> findByUsername(@RequestBody String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/email")
    public ResponseEntity<List<UserDTO>> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/lastname")
    public ResponseEntity<List<UserDTO>> findByLastname(@RequestBody String lastname) {
        return ResponseEntity.ok(userService.findByLastname(lastname));
    }

    @GetMapping("/firstname")
    public ResponseEntity<List<UserDTO>> findByFirstname(@RequestBody String firstname) {
        return ResponseEntity.ok(userService.findByFirstname(firstname));
    }

    @GetMapping("/findByCriteria")
    public ResponseEntity<List<UserDTO>> findByCriteria(@RequestBody UserForm form) {
        return ResponseEntity.ok(userService.findByCriteria(form));
    }
}