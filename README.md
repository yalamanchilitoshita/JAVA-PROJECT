# JAVA-PROJECT
ONLINE STORE CART &amp; ORDER PIPELINE
### Online Store Cart & Order Pipeline
# Online Store Cart & Order Pipeline

## Project Description

The **Online Store Cart & Order Pipeline** is a beginner-friendly Java console application that allows users to browse available products, add products to a shopping cart, view the cart, calculate the total amount, and place an order.

The program allows the user to:

* View available products
* Add products to the shopping cart
* View the shopping cart
* Calculate the total order amount
* Place an order
* Display the order summary
* Exit the application

## Technology Used

* Java
* Java `Scanner`
* Arrays
* Loops
* `if-else`
* `switch-case`
* Methods
* Console input/output

## Main Features

### 1. View Available Products

The program provides predefined products available in the online store:

* Laptop
* Smartphone
* Headphones
* Keyboard
* Mouse
* USB Cable
* Power Bank

Each product has a fixed price.

### 2. Add Products to Cart

The user can select a product and specify the quantity they want to purchase.

The selected products and quantities are stored in the shopping cart.

### 3. View Shopping Cart

The user can view all products currently added to the cart along with their quantities and prices.

The cart displays the subtotal for each product.

### 4. Calculate Total Amount

The program calculates the total order amount based on the selected products and their quantities.

The total is calculated using:

**Total = Product Price × Quantity**

The amounts for all selected products are added together to calculate the final cart total.

### 5. Place Order

After reviewing the shopping cart, the user can place the order.

The program validates that the cart contains products before allowing the order to be placed.

### 6. Display Order Summary

After placing the order, the program displays a simple order summary containing:

* Ordered products
* Quantities
* Individual prices
* Total order amount
* Order confirmation message

## Project Structure

```text
Online-Store-Cart-Order-Pipeline/
│
├── OnlineStore.java
├── Online-Store-Cart-and-Order-Pipeline.docx
├── README.md
├── .gitignore
└── Sample-Output.txt
```

## How to Run

### Step 1: Install Java

Install a Java JDK and make sure `java` and `javac` are available in your terminal.

### Step 2: Compile

Open the project folder in a terminal and run:

```bash
javac OnlineStore.java
```

### Step 3: Run

```bash
java OnlineStore
```

## Example Menu

```text
===== ONLINE STORE =====

1. View Available Products
2. Add Product to Cart
3. View Shopping Cart
4. Calculate Total
5. Place Order
6. View Order Summary
7. Exit

Enter your choice:
```

## Java Concepts Demonstrated

* Class and `main()` method
* Static methods
* Arrays
* `for` loops
* `do-while` loop
* `switch-case`
* `if-else`
* `Scanner`
* String handling
* Basic input validation
* Arithmetic operations
* Methods
* Menu-driven programming

## Project Documentation

The DOCX file contains the classroom project documentation, including:

* Project title
* Project abstract
* Project objectives
* Features
* Workflow
* Java code
* Sample output
* Advantages
* Limitations
* Validation checklist

## Current Version Notes

This is a classroom-scale console application designed for beginners learning Java.

The current implementation uses predefined product names and prices. It does not use a database, online payment system, real-time product inventory, external APIs, or an actual e-commerce website.

The application focuses on demonstrating basic Java programming concepts through a simple online shopping workflow.

## Author

**Toshita**

A beginner-friendly Java project that simulates the basic workflow of an online shopping system. Users can view available products, add products and quantities to a shopping cart, view their cart, automatically calculate the total price, and place an order. The project demonstrates fundamental Java concepts such as arrays, loops, conditional statements, switch statements, and user input using the Scanner class. It provides a simple understanding of how products, shopping carts, and order processing can work together in an online store.

