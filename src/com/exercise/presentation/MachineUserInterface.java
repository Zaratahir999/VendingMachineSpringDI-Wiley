package com.exercise.presentation;

import java.math.BigDecimal;

import com.exercise.exception.InsufficientFundsException;
import com.exercise.exception.NoItemInventoryException;

public interface MachineUserInterface {

	public void showMenu();
	public void performMenu(int choice, BigDecimal money) throws InsufficientFundsException, NoItemInventoryException;

	
}
