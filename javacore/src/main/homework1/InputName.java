package main.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputName {
    public String getName(String n) {
        String name = null;
        System.out.println(n + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            name = is.readLine();
            if(name.length() == 0) return null;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}
