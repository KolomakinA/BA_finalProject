package com.common;

/**
 * Created by kolom on 10.03.2017.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    public ArrayList<String> readFileAR(String path) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner s = new Scanner(new File(path));
        while (s.hasNext()){
            list.add(s.next());
        }
        return list;
    }

    public String readFileStr(String path) throws IOException{
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public long getCurrentTime(){
        return new Timestamp(System.currentTimeMillis()).getTime();
    }
}
