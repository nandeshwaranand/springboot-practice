package com.springbootpractice.dto.response;

import com.springbootpractice.entity.UserAccount;
import lombok.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserAccountResponse extends RepresentationModel<UserAccountResponse> {

    private Long userId;

    private String firstName;

    private String lastName;

    private String mobile;

    private String username;
}
