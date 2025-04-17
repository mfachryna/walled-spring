package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.request.RegisterRequest;
import id.co.bsi.walled.dto.response.LoginResponse;
import id.co.bsi.walled.dto.response.Response;
import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.AccountRepository;
import id.co.bsi.walled.repository.UserRepository;
import id.co.bsi.walled.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/auth")
public class AuthController {
    @Autowired
    private UserService userService;

//    @Autowired
//    private AccountRepository accountRepository;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user) {
        try {
            this.userService.registerUser(user);
        } catch (RuntimeException e) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        Response registerResponse = new Response();
        registerResponse.setStatus(true);
        registerResponse.setMessage("User created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<? extends Response> login(@RequestBody LoginRequest creds) {
        String token;
        try {
            token = this.userService.loginUser(creds);
        } catch (Exception e) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        LoginResponse loginResponse = new LoginResponse(token);
        loginResponse.setMessage("Login succeeded!");

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signout")
    public ResponseEntity<Response> signout() {
        boolean isLogout;

        try {
            isLogout = this.userService.signoutUser();
        } catch (RuntimeException e) {
            Response response = new Response();
            response.setStatus(false);
            response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        Response signoutResponse = new Response();
        signoutResponse.setStatus(isLogout);
        signoutResponse.setMessage("Signout succeeded!");

        return ResponseEntity.ok(signoutResponse);
    }

}
