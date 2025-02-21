package com.springbootpractice.entity;

import com.springbootpractice.constants.Constants;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_account", schema = Constants.AUTH_SCHEMA)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

    private String firstName;

    private String lastName;

    private String mobile;

    private String username;
}
