package com.exercise.presentation;

import java.math.BigDecimal;
import java.util.Scanner;

import com.exercise.dto.Items;
import com.exercise.exception.InsufficientFundsException;
import com.exercise.exception.NoItemInventoryException;
import com.exercise.service.MachineBusinessLogic;

public class MachineUserInterfaceImpl implements MachineUserInterface {

    //not creating object
	//dependency
	private MachineBusinessLogic machineBusinessLogic;

    //constructor
    public MachineUserInterfaceImpl(MachineBusinessLogic machineBusinessLogic) {
        super();
    	this.machineBusinessLogic = machineBusinessLogic;
    }
    
    
   

    @Override
    public void showMenu() {
        System.out.println("Vending Machine Menu :");
        System.out.println("1. Cookies - $0.74");
        System.out.println("2. Water Bottle - $1.00");
        System.out.println("3. Soda - $2.50");
        System.out.println("4. Cake - $2.45");
        System.out.println("5. Crisps - $1.23");
        System.out.println("6. Chocolate - $0.99");
        System.out.println("7. Candy - $1.02");
        System.out.println("8. Exit");
    }

    @Override
    public void performMenu(int choice, BigDecimal money) {
        switch (choice) {
            case 1:
                chooseItem("Cookies", new BigDecimal("0.74"), money);
                break;
            case 2:
                chooseItem("Water Bottle", new BigDecimal("1.00"), money);
                break;
            case 3:
                chooseItem("Soda", new BigDecimal("2.50"), money);
                break;
            case 4:
                chooseItem("Cake", new BigDecimal("2.45"), money);
                break;
            case 5:
                chooseItem("Crisps", new BigDecimal("1.23"), money);
                break;
            case 6:
                chooseItem("Chocolate", new BigDecimal("0.99"), money);
                break;
            case 7:
                chooseItem("Candy", new BigDecimal("1.02"), money);
                break;
            case 8:
                System.out.println("Exiting");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void chooseItem(String name, BigDecimal price, BigDecimal money) {
        try {
            BigDecimal change = machineBusinessLogic.chooseItem(name, price, money);
            
            if (change.compareTo(BigDecimal.ZERO) > 0) {
                System.out.println("\nYour change: $" + change);
            } else {
                System.out.println("\nThank you for buying " + name + ".");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("\nInsufficient funds. You have only entered " +money);
        } catch (NoItemInventoryException e) {
            System.out.println("\nItem out of stock. Please make another selection.");
        }
    }

}

