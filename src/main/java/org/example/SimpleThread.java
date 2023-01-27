package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleThread extends Thread {
    String readLine;
    File dataFile;
    long number;
    long resultat = 0;
    long tempResult = 0;
    int count = 0;

    public SimpleThread(File file) {
        dataFile = file;
    }
    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        try {
            FileReader fr = new FileReader(dataFile);
            BufferedReader br = new BufferedReader(fr);
            {
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("\"id\":40,\"number\":")) {
                        count++;
                        String result = readLine.substring(readLine.indexOf("\"id\":40,\"number\":"));
                        result = result.replaceAll("\"id\":40,\"number\":", "0r");
                        result = result.substring(0, result.indexOf("0r") + 15);
                        result = result.substring(result.indexOf("0r") + 2);
                        number = Long.parseLong(result);
                        tempResult += number;
                    }
                }
                resultat = (tempResult / count);
                System.out.println("Finally! The result is: " + resultat+ "\nThank you for using this programme!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
