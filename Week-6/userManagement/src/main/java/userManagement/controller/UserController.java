package userManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import userManagement.dto.AuthRequest;
import userManagement.model.User;
import userManagement.service.UserService;

/**
 * Controller for User endpoints (No JWT required)
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody User user) {
        String msg = service.register(user);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest request) {
        User user = service.login(request);
        log.info("Login successful for user: {}", user.getUsername());
        return ResponseEntity.ok("Login successful");
    }

    /**
     * Public profile endpoint (no token required)
     * Example: /users/profile?username=alice
     */
    @GetMapping("/profile")
    public ResponseEntity<User> getProfile(@RequestParam String username) {
        User user = service.getProfile(username);
        return ResponseEntity.ok(user);
    }
}
