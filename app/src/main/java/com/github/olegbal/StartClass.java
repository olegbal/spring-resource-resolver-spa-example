package com.github.olegbal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartClass {

    static private final String jarName = "static-data.jar";

    public static void main(String[] args) throws Exception {

        PathOperator.getJarContainingFolder(StartClass.class);
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder(System.getenv("JAVA_HOME")+"\\bin\\jar.exe", "-xf", Paths.executingPath + jarName, "resources/").start();
        } else {
            new ProcessBuilder("jar", "xf", Paths.executingPath + jarName, "resources/").start();
        }
        SpringApplication.run(StartClass.class, args);
    }
}
