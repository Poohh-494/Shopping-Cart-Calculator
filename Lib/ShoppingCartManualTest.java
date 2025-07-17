package Lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));  // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
        
        
        //Test 4: ส่วนลดจากราคารวม 10 %
        ArrayList<CartItem> discountCart = new ArrayList<>();
        discountCart.add(new CartItem("BULK", "Bread", 25.0, 6)); // 135
        discountCart.add(new CartItem("BULK", "Milk", 15.0, 8));  // 108
        double total4 = ShoppingCartCalculator.calculateTotalPrice(discountCart);
        if (total4 == 243) {
            System.out.println("PASSED: Discount cart total is correct (243.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Discount cart total expected 243.0 but got " + total4);
            failedCount++;
        }
        //Test 5: ของแถม
        ArrayList<CartItem> freeCart = new ArrayList<>();
        freeCart.add(new CartItem("BOGO", "Bread", 25.0, 4)); // 50
        freeCart.add(new CartItem("BOGO", "Milk", 15.0, 2));  // 15
        double total5 = ShoppingCartCalculator.calculateTotalPrice(freeCart);
        if (total5 == 65) {
            System.out.println("PASSED: Free cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Free cart total expected 65.0 but got " + total5);
            failedCount++;
        }
        //Test 6: ของรวม
         ArrayList<CartItem> allCart = new ArrayList<>();
        allCart.add(new CartItem("NORMAL", "Bread", 25.0, 4)); // 100
        allCart.add(new CartItem("BOGO", "Milk", 15.0, 2));  // 15
        allCart.add(new CartItem("BULK", "Egg", 10.0, 10));  // 90
        double total6 = ShoppingCartCalculator.calculateTotalPrice(allCart);
        if (total6 == 205) {
            System.out.println("PASSED: All cart total is correct (205.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: All cart total expected 205.0 but got " + total6);
            failedCount++;
        }
        
        
        
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    
    }
}