package cn.southstone.wuye.server.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fengs on 2016/7/29.
 */
@Component
public class RESTAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RESTAuthenticationSuccessHandler.class);

    private final ObjectMapper mapper;

    @Autowired
    RESTAuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
        this.mapper=messageConverter.getObjectMapper();
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //clearAuthenticationAttributes(request);
        response.setStatus(HttpServletResponse.SC_OK);
       UserDetails user=(UserDetails)authentication.getPrincipal();

       // userDetails.setUser(user);
        LOGGER.info(user.getUsername() + " got is connected");
        PrintWriter writer=response.getWriter();
        mapper.writeValue(writer, user);
        writer.flush();
    }
}
