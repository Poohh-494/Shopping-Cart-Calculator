package Lib;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     * @param  item sku name price quantity ที่ต้องการตรวจสอบ
     * @return total INVALID อื่นๆ
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double total = 0.0;
        if (items == null){
                return 0.0;
            }
        if (items.isEmpty()){
                return 0.0;
            }
        for(CartItem item : items){
            String sku = item.sku();
            String name = item.name();
            double price = item.price();
            int quantity = item.quantity();
        
        if (sku == "NORMAL"){
                total += price*quantity;
            }
            
        if (price < 0 || quantity < 0){
                return 0.0;
            }
        if (sku == "BOGO"){
            int quaBogoo = (quantity+1)/2;
            total += price*quaBogoo;
            
        }
        if (sku == "BULK"){
        if (quantity >= 6){
                total += price*quantity*0.9;
            }
        }
    }
        return total;
    }
}