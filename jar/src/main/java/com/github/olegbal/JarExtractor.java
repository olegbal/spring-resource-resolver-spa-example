package com.github.olegbal;

import java.io.IOException;

public class JarExtractor {
    public static void extractJarResources(String jarPath, String outPath) throws IOException {
        java.util.jar.JarFile jar = new java.util.jar.JarFile(jarPath);
        java.util.Enumeration enumEntries = jar.entries();
        while (enumEntries.hasMoreElements()) {
            java.util.jar.JarEntry file = (java.util.jar.JarEntry) enumEntries.nextElement();
            java.io.File f = new java.io.File(outPath + java.io.File.separator + file.getName());
            if (file.isDirectory()) { // if its a directory, create it
                    f.mkdir();
                    continue;
            }
            java.io.InputStream is = jar.getInputStream(file); // get the input stream
            java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
            while (is.available() > 0) {  // write contents of 'is' to 'fos'
                fos.write(is.read());
            }
            fos.close();
            is.close();
        }
        jar.close();
    }

}
