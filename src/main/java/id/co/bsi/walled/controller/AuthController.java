package id.co.bsi.walled.controller;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest login) {
        LoginResponse loginResponse = new LoginResponse("asdkjasdkajsldjalskjdlajskd!");
        loginResponse.setMessage("Login succeeded!");

        return ResponseEntity.ok(loginResponse);
    }
}
