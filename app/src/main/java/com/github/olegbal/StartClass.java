package com.github.olegbal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class StartClass {

    static private final String jarName = "static-data.jar";

    public static void main(String[] args) throws Exception {

        PathOperator.getJarContainingFolder(StartClass.class);
        if (System.getProperty("os.name").contains("Windows")) {
            ProcessBuilder pb = new ProcessBuilder(System.getenv("JAVA_HOME") + "\\bin\\jar.exe", "-xf", Paths.executingPath + jarName, "resources/");
            pb.directory(new File(Paths.executingPath));
            pb.start();
        } else {
            ProcessBuilder pb = new ProcessBuilder("jar", "xf", Paths.executingPath + jarName, "resources/");
            pb.directory(new File(Paths.executingPath));
            pb.start();
        }
        SpringApplication.run(StartClass.class, args);
    }
}
