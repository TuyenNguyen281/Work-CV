package springproject.service;

import springproject.entity.Role;

public interface RoleService {
    public Role getRoleByName(String name);
    public void saveRole(Role role);
}
