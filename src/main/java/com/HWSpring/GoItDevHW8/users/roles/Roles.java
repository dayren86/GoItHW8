package com.HWSpring.GoItDevHW8.users.roles;

import com.HWSpring.GoItDevHW8.users.Users;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Roles {
    @GeneratedValue
    @Id
    private UUID id;

    private String rolesName;

    @ToString.Exclude
    @OneToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private List<Users> users;
}
