package com.springbootpractice.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserAccountRequest {

    private Long userId;

    private String firstName;

    private String lastName;

    private String mobile;

    private String username;
}
