# SkyPay Banking System

A simple banking application that allows users to deposit money, withdraw money, and print account statements.

## Features

- Deposit money into account
- Withdraw money from account
- Print account statement with transaction history
- Exception handling for invalid operations
- Interactive command-line interface

## Project Structure

```
src/
├── main/
│   └── java/
│       ├── Main.java
│       └── com/bank/
│           ├── Account.java
│           ├── AccountService.java
│           └── Transaction.java
└── test/
    └── java/
        └── bank/
            └── AccountTest.java
```

## Requirements

- Java 17 or higher
- Maven (for dependency management and testing)

## How to Run

1. Compile the project:
   ```
   mvn clean compile
   ```

2. Run the application:
   ```
   java -cp target/classes Main
   ```

3. Follow the interactive menu to:
   - View current balance
   - Deposit money
   - Withdraw money
   - Print statement
   - Exit

## How to Test

Run all tests:
```
mvn test
```

## Rules

- Deposit and withdrawal amounts must be positive
- Cannot withdraw more than the current balance
- Transactions are displayed in reverse chronological order (most recent first)
- Statement format: `Date || Amount || Balance`

## Example Usage

```
=== Welcome to SkyPay Banking System ===

Current Balance: 0

Choose an operation:
1. Deposit
2. Withdraw
3. Print Statement
4. Exit

Enter your choice: 1
Enter amount to deposit: 1000
Successfully deposited 1000
```


