package cn.southstone.wuye.server.security.service.impl;

import cn.southstone.wuye.server.security.LoggedInChecker;
import cn.southstone.wuye.server.security.model.User;
import cn.southstone.wuye.server.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengs on 2016/7/29.
 */
@Service
public class UserServiceImpl implements UserService {

    private final static String USER_TEST = "root";

    private final LoggedInChecker loggedInChecker;

    @Autowired
    public UserServiceImpl(LoggedInChecker loggedInChecker) {
        this.loggedInChecker = loggedInChecker;
    }

    public User getUserByUsername(String username) {
        if (username.equals(USER_TEST)) {
            User user=new User();
            user.setUsername(USER_TEST);
            user.setPassword(new ShaPasswordEncoder().encodePassword("password",null));
            return user;
        }
        return null;
    }

    public List<String> getPermissions(String username) {
        return new ArrayList<String>();
    }

    public User getCurrentUser() {
        return loggedInChecker.getLoggedInUser();
    }

    public Boolean isCurrentUserLoggedIn() {
        return loggedInChecker.getLoggedInUser()!=null;
    }
}
