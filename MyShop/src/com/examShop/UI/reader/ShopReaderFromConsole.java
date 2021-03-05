package com.examShop.UI.reader;

import com.examShop.exceptions.Warehouse.WarehouseWrongInitDataException;
import com.examShop.exceptions.WrongInitDataException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShopReaderFromConsole implements ShopReader {
    public List<String> someRead(int dataCount) {
        System.out.println("-For exit put 0-");
        List<String> data = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("0")) {
            String tmp = scanner.nextLine();
            String[] formattedData = tmp.split("\\W+");
            if (formattedData.length != dataCount) {
                System.out.println("Wrong data");
                continue;
            }
            data.add(tmp);
        }
        return data;
    }
}