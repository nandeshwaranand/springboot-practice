package com.springbootpractice.entity;

import com.springbootpractice.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_roles", schema = Constants.USER_SCHEMA)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    private String roleDescription;
}
