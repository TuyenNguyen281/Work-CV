package springproject.config.userdetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springproject.entity.User;
import springproject.service.UserService;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
//        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRoleName());
//        grantedAuthorityList.add(authority);
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorityList);


        return UserPrinciple.build(user);
    }
}
