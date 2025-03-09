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
@Table(name = "workstation_details", schema = Constants.USER_SCHEMA)
public class WorkstationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workstationId;

    private String workstationName;

    private String workAddress;
}
