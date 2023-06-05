package com.exercise.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditDataAccess {
	
    public void eventTime(String event) {
    	
        LocalDateTime localDateTime = LocalDateTime.now();
        
        String formatted = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(event + ": " + formatted);
    }
}
