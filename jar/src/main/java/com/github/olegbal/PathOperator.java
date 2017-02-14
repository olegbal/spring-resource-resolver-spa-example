package com.github.olegbal;

import java.net.URLDecoder;

public class PathOperator {
    public static String parseString(String decodedPath) {
        StringBuilder stringBuilder = new StringBuilder(decodedPath);
        stringBuilder.delete(0, 5);
        int counter = 0;
        for (int i = stringBuilder.length() - 1; i > -1; i--) {
            if (stringBuilder.charAt(i) == '\\' || stringBuilder.charAt(i) == '/') {
                counter++;
            }
            if (counter == 4) {
                break;
            }
            stringBuilder.deleteCharAt(i);
        }
        return stringBuilder.toString();

    }

    public static String getJarContainingFolder(Class aclass) throws Exception {
        String path = aclass.getProtectionDomain().getCodeSource().getLocation().getPath();
        String decodedPath = URLDecoder.decode(path, "UTF-8");
        Paths.executingPath = parseString(decodedPath);
        return Paths.executingPath;
    }
}
