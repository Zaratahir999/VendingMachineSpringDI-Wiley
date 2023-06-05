package com.exercise.client;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exercise.exception.InsufficientFundsException;
import com.exercise.exception.NoItemInventoryException;
import com.exercise.presentation.MachineUserInterface;

public class Client {

    public static void main(String[] args) throws InsufficientFundsException, NoItemInventoryException {
  //  	MachineDataAccess machineDataAccess = new MachineDataAccessImpl();
   // 	AuditDataAccess auditDataAccess = new AuditDataAccess();
   // 	MachineBusinessLogicImpl machineBusinessLogic = new MachineBusinessLogicImpl(machineDataAccess, auditDataAccess);
   //     MachineUserInterface machineUserInterface = new MachineUserInterfaceImpl(machineBusinessLogic);

    	ApplicationContext springContainer=new ClassPathXmlApplicationContext("vendingmachine.xml");
    	
    	MachineUserInterface machineUserInterface=(MachineUserInterface)springContainer.getBean("userInterface");
        Scanner scanner = new Scanner(System.in);

        
        while (true) {
        	
        	machineUserInterface.showMenu();
                System.out.print("Enter money: ");
                BigDecimal money = scanner.nextBigDecimal();

                machineUserInterface.showMenu();
                System.out.print("Enter Choice: ");
                int choice = scanner.nextInt();

                if (choice == 8) {
                    System.out.println("Goodbye");
                    break;
                }

            machineUserInterface.performMenu(choice, money);
        }

        scanner.close();
    }
}
