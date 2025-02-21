package com.springbootpractice.service;

import com.springbootpractice.dto.request.UserAccountRequest;
import com.springbootpractice.entity.UserAccount;
import com.springbootpractice.respository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    UserAccountService(UserAccountRepository userAccountRepository){

        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount getUserAccountByUserId(Long userId){
        return userAccountRepository.findById(userId).orElseThrow();
    }

    public Object createUserAccount(UserAccountRequest userAccountRequest) {
        return userAccountRepository.save(buildUserAccount(userAccountRequest));
    }

    private UserAccount buildUserAccount(UserAccountRequest userAccountRequest){
        return UserAccount.builder()
                .firstName(userAccountRequest.getFirstName())
                .lastName(userAccountRequest.getLastName())
                .mobile(userAccountRequest.getMobile())
                .username(userAccountRequest.getUsername())
                .build();
    }
}
