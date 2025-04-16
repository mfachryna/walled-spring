package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.request.RegisterRequest;
import id.co.bsi.walled.dto.response.LoginResponse;
import id.co.bsi.walled.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest registerRequest)
    {
        if (registerRequest.getEmail() == null || registerRequest.getPassword() == null) {
            Response registerResponse = new Response();
            registerResponse.setFailure();
            registerResponse.setMessage("Email and password are required");
            return ResponseEntity.badRequest().body(registerResponse);
        }

        Response registerResponse = new Response();
        registerResponse.setSuccess();
        registerResponse.setMessage("Registration successful");

        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest login) {
        LoginResponse loginResponse = new LoginResponse("asdkjasdkajsldjalskjdlajskd!");
        loginResponse.setMessage("Login succeeded!");

        return ResponseEntity.ok(loginResponse);
    }
}
