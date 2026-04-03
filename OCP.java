import java.util.ArrayList;
import java.util.List;
 class Product {
        String name;
        int price;

        Product(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    class ShoppingCart {
        private List<Product> p = new ArrayList<>();

        public void addProduct(Product prod) {
            p.add(prod);
        }

        public List<Product> getProducts() {
            return p;
        }

        public int getTotal() {
            int sum = 0;
            for (int i = 0; i < p.size(); i++) {
                sum += p.get(i).price;
            }
            return sum;
        }
    }

    class InvoicePrinter {

        public void print(ShoppingCart cart) {
            System.out.println("Invoice");
            for (Product p : cart.getProducts()) {
                System.out.println("Product name" + p.name + "Price is" + p.price);
            }
            System.out.println("Total:" + cart.getTotal());
        }
    }

    interface Cartrepository {
        public void save(ShoppingCart cart);
    }

    class SQL implements Cartrepository {
        @Override
        public void save(ShoppingCart cart) {
            System.out.println(cart.getProducts().size() + "Saving to sql db.");
        }
    }
public class OCP {
   public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1200));
        Cartrepository repository = new SQL();
        repository.save(cart);
    }
}
