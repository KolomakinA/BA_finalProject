package com.common;

/**
 * Created by kolom on 10.03.2017.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Utils {
    public String readFile(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }
}
