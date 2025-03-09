package com.springbootpractice.entity;

import com.springbootpractice.constants.Constants;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_account", schema = Constants.USER_SCHEMA,
        uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAccountId;

    private String firstName;

    private String lastName;

    private String mobile;

    @Column(unique = true)
    private String username;

    @Transient // Not stored in the DB
    private int age;

    @OneToMany
    private List<Roles> roles; // One User can have multiple roles records.
}
