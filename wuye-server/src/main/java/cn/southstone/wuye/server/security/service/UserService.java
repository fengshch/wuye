package cn.southstone.wuye.server.security.service;

import cn.southstone.wuye.server.security.model.User;

import java.util.List;

/**
 * Created by fengs on 2016/7/29.
 */
public interface UserService {
    User getUserByUsername(String username);

    List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
