package springproject.config.userdetail;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springproject.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserPrinciple implements UserDetails {

    private static final int serialVersionUID = 1;
    private int id;

    private String fullName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> roles;


    public UserPrinciple(int id, String fullName, String email, String password, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public static UserPrinciple build(User user) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName());
        grantedAuthorityList.add(authority);
        return new UserPrinciple(user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                grantedAuthorityList);


    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
