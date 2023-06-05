package com.exercise.service;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.exercise.dto.Items;
import com.exercise.exception.InsufficientFundsException;
import com.exercise.exception.NoItemInventoryException;


public interface MachineBusinessLogic {
	
	  LinkedList<Items> getAllItems();
	  BigDecimal chooseItem (String name, BigDecimal price, BigDecimal money) throws InsufficientFundsException, NoItemInventoryException;

	  void saveQuantity();

	 

	      
	  }


	
	

