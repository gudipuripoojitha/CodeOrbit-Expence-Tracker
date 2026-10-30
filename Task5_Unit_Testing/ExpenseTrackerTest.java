package Task2_CLI_Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTrackerTest {

    @BeforeEach
    void setUp() {
        ExpenseTracker.expenses.clear();
        ExpenseTracker.nextId = 1;
    }

    @Test
    void testAddExpense() {
        boolean result = ExpenseTracker.addExpense("Food", 200);
        assertTrue(result);
        assertEquals(1, ExpenseTracker.expenses.size());
        assertEquals("Food", ExpenseTracker.expenses.get(0).name);
    }

    @Test
    void testAddExpenseWithInvalidAmount() {
        boolean result = ExpenseTracker.addExpense("Food", -100);
        assertFalse(result);
        assertEquals(0, ExpenseTracker.expenses.size());
    }

    @Test
    void testAddExpenseWithEmptyName() {
        boolean result = ExpenseTracker.addExpense("", 100);
        assertFalse(result);
        assertEquals(0, ExpenseTracker.expenses.size());
    }

    @Test
    void testDeleteExpense() {
        ExpenseTracker.addExpense("Travel", 300);
        boolean result = ExpenseTracker.deleteExpenseById(1);
        assertTrue(result);
        assertEquals(0, ExpenseTracker.expenses.size());
    }

    @Test
    void testDeleteNonExistingExpense() {
        boolean result = ExpenseTracker.deleteExpenseById(99);
        assertFalse(result);
    }

    @Test
    void testCalculateTotalExpenses() {
        ExpenseTracker.addExpense("Food", 200);
        ExpenseTracker.addExpense("Travel", 300);
        double total = ExpenseTracker.getTotalExpenses();
        assertEquals(500.0, total, 0.001);
    }

    @Test
    void testTotalWhenNoExpenses() {
        assertEquals(0.0, ExpenseTracker.getTotalExpenses(), 0.001);
    }
}
