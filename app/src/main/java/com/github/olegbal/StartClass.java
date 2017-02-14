package com.github.olegbal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartClass {

    static private final String jarName = "static-data.jar";

    public static void main(String[] args) throws Exception {

        PathOperator.getJarContainingFolder(StartClass.class);
        if (System.getProperty("os.name").contains("Windows")) {
            JarExtractor.extractJarResources(Paths.executingPath+jarName,Paths.executingPath);
        } else {
            new ProcessBuilder("jar", "xf", Paths.executingPath + jarName, "resources/").start();
        }
        SpringApplication.run(StartClass.class, args);
    }

}
