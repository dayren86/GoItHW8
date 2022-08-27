package com.HWSpring.GoItDevHW8.users;

import com.HWSpring.GoItDevHW8.users.roles.Roles;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "users")
@Entity
public class Users {

    @Id
    @GeneratedValue
    private UUID id;

    private String email;

    private String passwords;

    private String firstName;

    private String lastName;


    @ManyToOne(fetch = FetchType.EAGER)
    private Roles roles;
}
