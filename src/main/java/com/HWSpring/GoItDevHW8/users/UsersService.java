package com.HWSpring.GoItDevHW8.users;

import com.HWSpring.GoItDevHW8.users.roles.RolesService;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final RolesService rolesService;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public void create(String email, String password, String firsName, String lastName, UUID uuid) {
        Users users = new Users();
        users.setEmail(email);
        users.setPasswords(password);
        users.setFirstName(firsName);
        users.setLastName(lastName);
        users.setRoles(rolesService.getRolesByUUID(uuid));
        usersRepository.save(users);
    }
    public Users getByUUID(UUID uuid) {
       return usersRepository.getReferenceById(uuid);
    }

    public void update(UUID uuidUsers, String email, String password, String firsName, String lastName, UUID uuidRoles ) {
        Users users = getByUUID(uuidUsers);
        users.setEmail(email);
        users.setPasswords(password);
        users.setFirstName(firsName);
        users.setLastName(lastName);
        users.setRoles(rolesService.getRolesByUUID(uuidRoles));

        usersRepository.save(users);
    }

    public void delete(UUID uuid) {
        usersRepository.deleteById(uuid);
    }

    public UserRowMapper getPasswordAndRoles(String email) {
        String sql = "SELECT passwords, roles_name " +
                "FROM users " +
                "JOIN roles ON roles_id = roles.id " +
                "WHERE email = :email";
        return jdbcTemplate.queryForObject(sql, Map.of("email", email), new RowMapper<UserRowMapper>() {
            @Override
            public UserRowMapper mapRow(ResultSet rs, int rowNum) throws SQLException {
                return UserRowMapper.builder()
                        .passwords(rs.getString("passwords"))
                        .roles(rs.getString("roles_name"))
                        .build();
            }
        });
    }

    @Builder
    @Data
    public static class UserRowMapper {
        private String passwords;
        private String roles;
    }

}
