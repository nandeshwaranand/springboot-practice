package com.springbootpractice.jpa.relations;

import com.springbootpractice.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pan_details", schema = Constants.USER_SCHEMA)
public class PANDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long panDetailsId;

    private String userId;

    private String uan;

    private String pan;

    //Non owning table
    //@OneToOne(mappedBy = "panDetails") // Tells Hibernate that User owns the relationship
    //private User user;
}
