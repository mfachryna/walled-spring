package id.co.bsi.walled.controller;


import id.co.bsi.walled.dto.response.UserAccountsResponse;
import id.co.bsi.walled.dto.response.UserDetailResponse;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public ResponseEntity <UserDetailResponse> userDetailResponseResponse (){

        User user = this.userRepository.findByEmail("test@example.com");
        UserDetailResponse userDetailResponse = new UserDetailResponse(user);
        userDetailResponse.setMessage("User profile retrieved");
        return ResponseEntity.ok(userDetailResponse);
    }

    @GetMapping("/account")
    public ResponseEntity <UserAccountsResponse> userAccountsResponseResponse (){
        UserAccountsResponse userAccounts = new UserAccountsResponse(1,"706044871", "1500000");
        return ResponseEntity.ok(userAccounts);
    }
}
