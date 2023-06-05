package com.exercise.persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import com.exercise.dto.Items;

public class MachineMarshalling {

		public static void main(String[] args) {		
		LinkedList<Items> items = new LinkedList<>();
	
		items.add(new Items("Cookies", new BigDecimal("0.74"), 10));
        items.add(new Items("Water Bottle", new BigDecimal("1.00"), 10));
        items.add(new Items("Soda", new BigDecimal("2.50"), 10));
        items.add(new Items("Cake", new BigDecimal("2.45"), 10));
        items.add(new Items("Crisps", new BigDecimal("1.23"), 10));
        items.add(new Items("Chocolate", new BigDecimal("0.99"), 10));
        items.add(new Items("Candy", new BigDecimal("1.02"), 10));

		
		  try (PrintWriter printWriter = new PrintWriter(new FileWriter("ItemsData.txt"))) {
		        items.stream()
		                .map(item -> item.getName() + "," + item.getPrice() + "," + item.getQuantity())
		                .forEach(printWriter::println);
		    } catch (IOException e) {
		        e.printStackTrace();
		        
		    }

		    
		}
		
		

		 }

		     
		        
		        
		        
		        
		        