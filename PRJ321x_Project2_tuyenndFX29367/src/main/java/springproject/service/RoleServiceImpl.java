package springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import springproject.dao.RoleDAO;
import springproject.entity.Role;



@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }
}
