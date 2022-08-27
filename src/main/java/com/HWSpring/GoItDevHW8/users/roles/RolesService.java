package com.HWSpring.GoItDevHW8.users.roles;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles getRolesByUUID(UUID uuid) {
        return rolesRepository.getReferenceById(uuid);
    }

    public void create(String name) {
        Roles roles = new Roles();
        roles.setRolesName(name);
        rolesRepository.save(roles);
    }

    public void delete(UUID uuid) {
        rolesRepository.deleteById(uuid);
    }

    public void update(UUID uuid, String name) {
        Roles roles = getRolesByUUID(uuid);
        roles.setRolesName(name);
        rolesRepository.save(roles);
    }
}
