package com.exercise.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import com.exercise.dto.Change;
import com.exercise.dto.Items;
import com.exercise.exception.InsufficientFundsException;
import com.exercise.exception.NoItemInventoryException;
import com.exercise.persistence.AuditDataAccess;
import com.exercise.persistence.MachineDataAccess;
import com.exercise.persistence.MachineDataAccessImpl;

public class MachineBusinessLogicImpl implements MachineBusinessLogic {

    
	private MachineDataAccess dataAccess;
	
    
    
    private LinkedList<Items> itemList;
    private AuditDataAccess auditDataAccess;
    
  

	//instance block
    {
		try {
			itemList=MachineDataAccessImpl.readRecords();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    

	
	public MachineBusinessLogicImpl(MachineDataAccess dataAccess) {
	super();
	this.dataAccess = dataAccess;
	}


	public void setAuditDataAccess(AuditDataAccess auditDataAccess) {
		this.auditDataAccess = auditDataAccess;
	}


	public void setItemList(LinkedList<Items> itemList) {
		this.itemList = itemList;
	}



	@Override
    public LinkedList<Items> getAllItems() {
        return itemList;
    }

    @Override
    public BigDecimal chooseItem(String name, BigDecimal price, BigDecimal money) throws InsufficientFundsException, NoItemInventoryException {
    	
        Items item = getItemByName(name);
        
        if (item == null) {
            throw new IllegalArgumentException("Invalid item name");
        }

        BigDecimal itemPrice = item.getPrice();
        int itemQuantity = item.getQuantity();

        if (itemQuantity == 0) {
        	itemList.remove(item);
        	saveQuantity();
            throw new NoItemInventoryException("Item out of stock");
        }

        if (money.compareTo(itemPrice) < 0) {
            throw new InsufficientFundsException("\nInsufficient funds");
        }

        BigDecimal change = money.subtract(itemPrice);
        item.setQuantity(itemQuantity - 1);
        saveQuantity();
        
        if (auditDataAccess != null) {
        auditDataAccess.eventTime("Time item bought");
        }
        

        
        

        BigDecimal changeInPennies = change.multiply(new BigDecimal("100")).setScale(0);
        Change changeObject = new Change(changeInPennies.intValue());

        System.out.println("\nChange: ");
        System.out.println("Quarters: " + changeObject.getQuarters());
        System.out.println("Dimes: " + changeObject.getDimes());
        System.out.println("Nickels: " + changeObject.getNickels());
        System.out.println("Pennies: " + changeObject.getPennies());

        change = change.setScale(2, RoundingMode.HALF_UP);
        return change;
    }

    @Override
    public void saveQuantity() {
        dataAccess.writeRecords(itemList);
    }

    private Items getItemByName(String name) {
        for (Items item : itemList) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
