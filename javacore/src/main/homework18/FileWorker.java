package main.homework18;

import main.homework18.family.Family;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWorker {
    private final static String fileStr = "src/main/homework18/FamilyDB.txt";
    private final static File file = new File(fileStr);
    public static void write(List<Family> families) {
        //File file = new File();

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(families);
                out.print("");
                out.print("\n");

            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }


    }
}
