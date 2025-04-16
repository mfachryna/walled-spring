package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.request.RegisterRequest;
import id.co.bsi.walled.dto.response.LoginResponse;
import id.co.bsi.walled.dto.response.Response;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user) {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Full name is required");
            return ResponseEntity.badRequest().body(response);
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Email is required");
            return ResponseEntity.badRequest().body(response);
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Password is required");
            return ResponseEntity.badRequest().body(response);
        }

        if (user.getPassword().length() < 8) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Password must be at least 8 characters long");
            return ResponseEntity.badRequest().body(response);
        }

        if (this.userRepository.findByEmail(user.getEmail()) != null) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Email already exists");
            return ResponseEntity.badRequest().body(response);
        }

        this.userRepository.save(user);
        Response registerResponse = new Response();
        registerResponse.setStatus(true);
        registerResponse.setMessage("User created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<? extends Response> login(@RequestBody LoginRequest creds) {
        if (creds.getEmail() == null || creds.getEmail().isEmpty()) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Email is required");
            return ResponseEntity.badRequest().body(response);
        }

        if (creds.getPassword() == null || creds.getPassword().isEmpty()) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Password is required");
            return ResponseEntity.badRequest().body(response);
        }

        User user = this.userRepository.findByEmailAndPassword(creds.getEmail(), creds.getPassword());
        if (user == null) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage("Invalid email or password");
            return ResponseEntity.badRequest().body(response);
        }

        LoginResponse loginResponse = new LoginResponse("dummyAccessToken");
        loginResponse.setMessage("Login succeeded!");

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signout")
    public ResponseEntity<Response> signout() {
        Response response = new Response();
        response.setStatus(true);
        response.setMessage("Logout success");
        return ResponseEntity.ok(response);
    }

}
