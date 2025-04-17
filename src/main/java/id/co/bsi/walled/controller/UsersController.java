package id.co.bsi.walled.controller;


import id.co.bsi.walled.dto.response.UserAccountsResponse;
import id.co.bsi.walled.dto.response.UserDetailResponse;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.UserRepository;
import id.co.bsi.walled.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public ResponseEntity <UserDetailResponse> getUserDetail(){
        UserDetailResponse response = userService.getUserDetail();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/account")
    public ResponseEntity <UserAccountsResponse> getUserAccount(){
        UserAccountsResponse response = userService.getUserAccount();
        return ResponseEntity.ok(response);
    }
}
