Task 5 – Unit Testing Practice

Project

Expense Tracker Application using Java.

Objective

To practice unit testing by testing the main operations of the Expense Tracker application using JUnit 5.

Testing Framework

- JUnit 5
- Java JDK 17
- Visual Studio Code

Test Cases

1. testAddExpense() – Checks adding a valid expense.
2. testAddExpenseWithInvalidAmount() – Checks rejection of a negative amount.
3. testAddExpenseWithEmptyName() – Checks rejection of an empty name.
4. testDeleteExpense() – Checks deleting an existing expense.
5. testDeleteNonExistingExpense() – Checks deletion of a non-existing expense.
6. testCalculateTotalExpenses() – Checks total expense calculation.
7. testTotalWhenNoExpenses() – Checks the total when no expenses exist.

Test Results

- Total Tests: 7
- Passed: 7
- Failed: 0

How to Run

Run the tests using Maven:

"mvn test"

Conclusion

All seven unit tests passed successfully. The tests cover normal operations and edge cases of the Expense Tracker application.
