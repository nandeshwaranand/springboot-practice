package com.springbootpractice.service;

import com.springbootpractice.dto.request.UserAccountRequest;
import com.springbootpractice.dto.response.UserAccountResponse;
import com.springbootpractice.entity.UserAccount;
import com.springbootpractice.exception.UserNotFoundException;
import com.springbootpractice.respository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    UserAccountService(UserAccountRepository userAccountRepository){

        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    public UserAccount getUserAccountByUserId(Long userId){
       return userAccountRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with user id:"+userId));
    }

    public UserAccountResponse createUserAccount(UserAccountRequest userAccountRequest) {
        UserAccount userAccount = userAccountRepository.save(buildUserAccount(userAccountRequest));
        return buildUserAccountResponse(userAccount);
    }

    private UserAccount buildUserAccount(UserAccountRequest userAccountRequest){
        return UserAccount.builder()
                .firstName(userAccountRequest.getFirstName())
                .lastName(userAccountRequest.getLastName())
                .mobile(userAccountRequest.getMobile())
                .username(userAccountRequest.getUsername())
                .build();
    }

    private UserAccountResponse buildUserAccountResponse(UserAccount userAccount){
        return UserAccountResponse.builder()
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .mobile(userAccount.getMobile())
                .username(userAccount.getUsername())
                .build();
    }
}
