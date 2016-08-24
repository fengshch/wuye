package cn.southstone.wuye.server.security;

import cn.southstone.wuye.server.security.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by fengs on 2016/7/29.
 */
@Component
public class LoggedInChecker {
    public User getLoggedInUser(){
        User user=null;

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal=authentication.getPrincipal();

            if (principal instanceof RESTUserDetails) {
                RESTUserDetails userDetails=(RESTUserDetails)principal;
                user=userDetails.getUser();
            }
        }
        return user;
    }

}
