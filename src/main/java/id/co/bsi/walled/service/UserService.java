package id.co.bsi.walled.service;

import id.co.bsi.walled.dto.response.UserAccountsResponse;
import id.co.bsi.walled.dto.response.UserDetailResponse;
import id.co.bsi.walled.model.User;
import id.co.bsi.walled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
