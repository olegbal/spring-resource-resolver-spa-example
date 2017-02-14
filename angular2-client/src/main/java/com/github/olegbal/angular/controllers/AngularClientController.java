package com.github.olegbal.angular.controllers;

import com.github.olegbal.Paths;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class AngularClientController {

    @RequestMapping(path = "/changeclient/angular/", method = RequestMethod.GET)
    public void changeOnAngularClient() throws IOException {
        FileCopyUtils.copy(new File(Paths.executingPath + "/resources/angular/index.html"),
                new File(Paths.executingPath + "/resources/index.html"));
    }
}
