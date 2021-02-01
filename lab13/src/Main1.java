public class Main1 {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct("Big Java", 300, 5);
        store.addProduct("Da Vinci Code", 120, 0);
        store.addProduct("Python 101", 200, 10);

        int countAllProduct = store.countProduct(new Counter() {
            @Override
            public int count(Product product) {
                return 1;
            }
        });
        System.out.println(countAllProduct);

        int countProductInStock = store.countProduct(new Counter() {
            @Override
            public int count(Product product) {
                if (product.getQuantity() > 0) return 1;
                return 0;
            }
        });

        int countProductQuantity = store.countProduct(new Counter() {
            @Override
            public int count(Product product) {
                return product.getQuantity();
            }
        });
    }
}
