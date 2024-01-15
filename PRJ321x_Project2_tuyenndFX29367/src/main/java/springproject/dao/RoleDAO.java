package springproject.dao;

import springproject.entity.Role;

public interface RoleDAO {

    public Role getRoleByName(String name);
    public void saveRole(Role role);
}
