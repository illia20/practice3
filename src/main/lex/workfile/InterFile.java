package main.lex.workfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InterFile {
    public static File openFile(String path) {
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File " + path + " not found!");
            System.exit(1);
        }
        return file;
    }

    public static File createFile(String path) {
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File " + path + " not found!");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public static void readFile(File file, Function f){
        try {
            FileInputStream stream = new FileInputStream(file);
            int c, prev = 0;
            while ((c = stream.read()) != -1){
                f.handle((char)c, (char)prev);
                prev = c;
            }
            f.handle(' ', (char) prev);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
