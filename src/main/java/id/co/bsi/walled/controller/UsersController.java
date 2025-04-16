package id.co.bsi.walled.controller;


import id.co.bsi.walled.dto.response.UserAccountsResponse;
import id.co.bsi.walled.dto.response.UserDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UsersController {

    @GetMapping("/profile")
    public ResponseEntity <UserDetailResponse> userDetailResponseResponse (){
        UserDetailResponse userDetailResponse = new UserDetailResponse("dimas","dimas@gmail.com","1234567890","dimas.com");
        userDetailResponse.getFull_name();
        userDetailResponse.getEmail();
        userDetailResponse.getMobile_phone();
        userDetailResponse.getImage_url();
        return ResponseEntity.ok(userDetailResponse);
    }

    @GetMapping("/account")
    public ResponseEntity <UserAccountsResponse> userAccountsResponseResponse (){
        UserAccountsResponse userAccounts = new UserAccountsResponse(1,"706044871", "1500000");
        userAccounts.getId();
        userAccounts.getAccount_number();
        userAccounts.getBalance();
        return ResponseEntity.ok(userAccounts);
    }
}
