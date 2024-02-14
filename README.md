# Vending Machine Simulation Assignment

## Overview
Your assignment for this lab is to create a program that simulates a vending machine using the Spring Dependency Injection (DI) container.

## Requirements

### Features:
- Display all items and their respective prices when the program starts, along with an option to exit the program.
- Require the user to input money before selecting an item.
- Allow only one item to be vended at a time.
- Display a message for insufficient funds if the selected item costs more than the user's input money, then redisplay the amount the user had put into the machine.
- Display the change returned to the user in quarters, dimes, nickels, and pennies if the selected item costs equal to or less than the input money.

### Data Management:
- Vending machine items must be stored in a file.
- Inventory must be read from this file at program start and written back to it before program exit.
- The program must track the following properties for each item:
  - Item name
  - Item cost
  - Number of items in inventory
