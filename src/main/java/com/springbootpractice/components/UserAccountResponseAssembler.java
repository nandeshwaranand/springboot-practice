package com.springbootpractice.components;

import com.springbootpractice.controller.UserController;
import com.springbootpractice.dto.response.UserAccountResponse;
import com.springbootpractice.entity.UserAccount;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Building user account response by adding supported links for user account by HATEOAS
 */
@Component
public class UserAccountResponseAssembler implements RepresentationModelAssembler<UserAccount, UserAccountResponse> {

    @Override
    public UserAccountResponse toModel(UserAccount entity) {
        UserAccountResponse userAccountResponse = buildUserAccountResponse(entity);
        userAccountResponse.add(linkTo(methodOn(UserController.class).getUserById(entity.getUserAccountId())).withSelfRel());
        userAccountResponse.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        return userAccountResponse;
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
