package com.examShop.UI.reader;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShopReaderFromFile implements ShopReader {
    public List<String> someRead() {
        System.out.println("-Insert path to file-");
        Scanner consoleScanner = new Scanner(System.in);
        List<String> data = new LinkedList<>();
        String fileName = consoleScanner.nextLine();
        Path path = Paths.get(fileName);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(path);
            fileScanner.useDelimiter(System.getProperty("line.separator"));
            while (fileScanner.hasNext()) {
                String tmp = fileScanner.next();
                data.add(tmp);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.err.println("No info read!");
        }
        return data;
    }
}
