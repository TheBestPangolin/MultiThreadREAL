package org.example;

public class WorkWithLine implements Runnable {
private String line;

    public WorkWithLine(String line) {
        this.line = line;
        System.out.println(this.line);
    }

    @Override
    public void run() {

    }
}
