package cn.southstone.wuye.server.security;

import cn.southstone.wuye.server.security.model.User;
import cn.southstone.wuye.server.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengs on 2016/7/29.
 */
@Service
public class RESTUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public RESTUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        List<String> permissions = userService.getPermissions(user.getUsername());
        for (String permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission));
        }
        return new RESTUserDetails(user, grantedAuthorities);

    }
}
