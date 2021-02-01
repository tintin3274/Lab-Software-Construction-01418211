import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;
    public Store() { products = new ArrayList<>(); }
    public void addProduct(String name, double price, int qty) {
        products.add(new Product(name, price, qty));
    }

    public int countProduct(Counter counter){
        int count = 0;
        for (Product product: products){
            count += counter.count(product);
        }
        return count;
    }

//    // นับจํานวนสินค้าทั้งหมด ทั้งมีในสต็อคหรือหมดสต็อคแล้ว
//    public int countAllProduct() {
//        int count = 0;
//        for (Product prod : products) {
//            count += 1;
//        }
//        return count;
//    }
//
//    // นับจํานวนสินค้าทั้งหมดที่มีเหลืออยู่ในสต็อค
//    public int countProductInStock() {
//        int count = 0;
//        for (Product prod : products) {
//            if (prod.getQuantity() > 0)
//                count += 1;
//        }
//        return count;
//    }
//    // นับจํานวนในสต็อคของสินค้าทั้งหมด
//    public int countProductQuantity() {
//        int count = 0;
//        for (Product prod : products) {
//            count += prod.getQuantity();
//        }
//        return count;
//    }
}