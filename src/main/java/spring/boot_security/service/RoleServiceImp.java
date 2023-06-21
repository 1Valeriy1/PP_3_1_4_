package spring.boot_security.service;

import org.springframework.transaction.annotation.Transactional;
import spring.boot_security.dao.RoleDao;
import spring.boot_security.models.Role;
import spring.boot_security.models.User;

import java.util.HashSet;
import java.util.Set;

public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional
    public Set<Role> setRoles() {
        return new HashSet(roleDao.findAll());
    }

    @Override
    public User getRoleByName(String role) {
        return null;
    }
}
