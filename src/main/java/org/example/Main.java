package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String file ="Bsjadqwpurbvjfqs_data.txt";
        File dataFile=new File("Input_Data",file);
        SimpleThread thread=new SimpleThread(dataFile);
        thread.start();
    }
}