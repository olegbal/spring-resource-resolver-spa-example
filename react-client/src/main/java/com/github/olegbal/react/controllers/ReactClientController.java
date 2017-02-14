package com.github.olegbal.react.controllers;

import com.github.olegbal.Paths;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class ReactClientController {

    @RequestMapping(path = "/changeclient/react/", method = RequestMethod.GET)
    public void changeOnReactClient() throws IOException {
        FileCopyUtils.copy(new File(Paths.executingPath + "/resources/react/index.html"),
                new File(Paths.executingPath + "/resources/index.html"));
    }
}
