package spring.boot_security.service;

import spring.boot_security.models.Role;
import spring.boot_security.models.User;

import java.util.Set;

public interface RoleService {
    public void add(Role role);
    public Set<Role> setRoles();
    public User getRoleByName(String role);
}
