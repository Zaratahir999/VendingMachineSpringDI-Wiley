package com.exercise.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.exercise.dto.Items;

public class MachineDataAccessImpl implements MachineDataAccess {
	
//no depedencies eg no private property
	
	@Override
	public boolean writeRecords(LinkedList<Items> items) {
	    try (PrintWriter printWriter = new PrintWriter(new FileWriter("ItemsData.txt"))) {
	        items.stream()
	                .map(item -> item.getName() + "," + item.getPrice() + "," + item.getQuantity())
	                .forEach(printWriter::println);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false; 
	    }

	    return true; 
	}



	public static LinkedList<Items> readRecords() throws Exception{
	    LinkedList<Items> items = new LinkedList<>();
	
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader("ItemsData.txt"))) {
	        items = reader.lines()
	                .map(line -> line.split(","))
	                .filter(data -> data.length == 3)
	                .map(data -> {
	                    String name = data[0];
	                    BigDecimal price = new BigDecimal(data[1]);
	                    int quantity = Integer.parseInt(data[2]);
	                    Items item = new Items(name, price, quantity);
	                    return item;
	                })
	                .collect(Collectors.toCollection(LinkedList::new));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return items;
	}
}