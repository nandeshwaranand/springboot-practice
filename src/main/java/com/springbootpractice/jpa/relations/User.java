package com.springbootpractice.jpa.relations;

import com.springbootpractice.constants.Constants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A One-to-One relationship in Hibernate/JPA means that a single instance of an entity
 * is related to only one instance of another entity.
 * e.g., A record in User table relates to only one record in PANDetails table vice versa.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details", schema = Constants.USER_SCHEMA)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key using the database identity column.
    private Long userId;

    /**
     * Unidirectional --> Only one entity maintains a reference to the other entity.
     * Can only navigate the relationship from User to work station.
     * User table knows about WorkstationDetails table, but WorkstationDetails does not know about User.
     * The foreign key is stored in the table of the referencing entity
     * (additional column will be created in user table which refers the work station table).
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workstation_id")
    private WorkstationDetails workstationDetails;

    /**
     * Bidirectional --> Both entities are aware of the relationship.
     * A reference exists in both tables, but the foreign key is in only one of them.
     * (additional column will be created in user table which refers the user account table).
     * Can navigate the relationship from User to pan details and vice versa.
     */
   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pan_details_id", unique = true)
    private PANDetails panDetails;*/

    /*    @OneToOne(cascade = CascadeType.ALL)// Defines a one-to-one relationship between two entities.
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount userAccount;*/
}
