package com.github.olegbal.angular.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AngularClientController {

    @RequestMapping(path = "/changeclient/angular/", method = RequestMethod.GET)
    public RedirectView changeOnAngularClient(HttpServletResponse response) throws IOException {

        Cookie cookie = new Cookie("client", "angular");
        cookie.setPath("/");
        response.addCookie(cookie);
        return new RedirectView("/");
    }
}
