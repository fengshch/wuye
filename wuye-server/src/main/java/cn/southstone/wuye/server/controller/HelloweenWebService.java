package cn.southstone.wuye.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by fengs on 2016/7/29.
 */

@RestController()
@RequestMapping("/rest")
public class HelloweenWebService {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloweenResponse> hello(Principal principal) {
        return new ResponseEntity<HelloweenResponse>(
                new HelloweenResponse("Happy Halloween, "+principal.getName()+"!"), HttpStatus.OK);
    }

    @RequestMapping(value = "/hellopost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloweenResponse> helloPost(Principal principal) {

        return new ResponseEntity<HelloweenResponse>(
                new HelloweenResponse("Happy posting, " + principal.getName() + "!"), HttpStatus.OK);
    }

    public static class HelloweenResponse{
        private String message;

        public HelloweenResponse(String message) {
            this.message=message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
