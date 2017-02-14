package com.github.olegbal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;

@SpringBootApplication
public class StartClass {

    static private final String jarName = "static-data.jar";

    public static void main(String[] args) throws Exception {

        PathOperator.getJarContainingFolder(StartClass.class);

        new ProcessBuilder("jar", "xf", Paths.executingPath + jarName, "resources/").start();
        SpringApplication.run(StartClass.class, args);
    }

}
