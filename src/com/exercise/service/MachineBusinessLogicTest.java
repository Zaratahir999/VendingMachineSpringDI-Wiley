package com.exercise.service;

import com.exercise.dto.Items;
import com.exercise.exception.InsufficientFundsException;
import com.exercise.persistence.AuditDataAccess;
import com.exercise.persistence.MachineDataAccess;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MachineBusinessLogicTest {
	
	private MachineBusinessLogic businessLogic;
	private AuditDataAccess auditDataAccess;
	private MachineDataAccess dataAccess;
    private LinkedList<Items> itemList;

	@BeforeEach
	void setUp() throws Exception {
		itemList = new LinkedList<>();
        itemList.add(new Items("Cookies", new BigDecimal("0.75"), 5));
        itemList.add(new Items("Water Bottle", new BigDecimal("1.00"), 0));
        dataAccess = new MachineDataAccessCheck(itemList);
        businessLogic = new MachineBusinessLogicImpl(dataAccess);
	}

	
	void testGetAllItems() {
		 LinkedList<Items> result = businessLogic.getAllItems();
	        assertEquals(itemList, result);
	}
       
	@Test
    void testChooseItem_InsufficientFunds() {
        assertThrows(InsufficientFundsException.class, () -> {
            businessLogic.chooseItem("Cookies", new BigDecimal("0.75"), new BigDecimal("0.50"));
        });
    }
	

    private static class MachineDataAccessCheck implements MachineDataAccess {
        private LinkedList<Items> itemList;

        MachineDataAccessCheck(LinkedList<Items> itemList) {
            this.itemList = itemList;
        }

        
        public LinkedList<Items> readRecords() {
            return itemList;
        }

        @Override
        public boolean writeRecords(LinkedList<Items> items) {
        	return true;
        }
    }
}



