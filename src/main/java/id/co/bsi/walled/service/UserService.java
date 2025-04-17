package id.co.bsi.walled.service;

import id.co.bsi.walled.dto.request.LoginRequest;
import id.co.bsi.walled.dto.response.Response;
import id.co.bsi.walled.dto.response.UserAccountsResponse;
import id.co.bsi.walled.dto.response.UserDetailResponse;
import id.co.bsi.walled.model.Account;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.AccountRepository;
import id.co.bsi.walled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public String HashPassword(String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        return passwordEncoder.encode(password);
        return password;
    }

    public User registerUser(User user) {
        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            throw new RuntimeException("Full name is required");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        if (user.getPassword().length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long");
        }

        if (this.userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(HashPassword(user.getPassword()));
        User newUser = this.userRepository.save(user);

        Account newAccount = new Account();
        newAccount.setUser(newUser);
        newAccount.setBalance(1000000);
        newAccount.setAccountNumber("706044871");

        this.accountRepository.save(newAccount);

        return newUser;
    }

    public String loginUser(LoginRequest creds) {
        if (creds.getEmail() == null || creds.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required");
        }

        if (creds.getPassword() == null || creds.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        creds.setPassword(HashPassword(creds.getPassword()));

        User user = this.userRepository.findByEmailAndPassword(creds.getEmail(), creds.getPassword());

        // Implement jwt

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        } else {
            return "dummyAccessTokenUserService";
        }
    }

    public boolean signoutUser() {
        // Implement signout logic
        return true;
    }

    public UserDetailResponse getUserDetail(){
        User user = userRepository.findByEmail("test@example.com");
        UserDetailResponse response = new UserDetailResponse(user);
        response.setMessage("User profile retrieved");
        return response;
    }

    public UserAccountsResponse getUserAccount() {
        return new UserAccountsResponse(1, "706044871", "1500000");
    }
}
