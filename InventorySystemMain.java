
import java.util.Scanner;

public class InventorySystemMain {
    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();
        OrderManager orderManager = new OrderManager();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;

        //menu
        while (active){
            System.out.println("1. Add Product \n" + 
                                "2. Remove Product\n" + 
                                "3. Find Product\n" +
                                "4. List All Products\n" +
                                "5. Create Order\n" + 
                                "6. View Orders\n" + 
                                "7. Process Order\n" + 
                                "8. Generate Reports\n" + 
                                "9. Exit");
            int input = scanner.nextInt();
            if (input == 1){
                addProduct(inventory, scanner);
            } else if (input == 2){
                removeProduct(inventory, scanner);
            } else if (input == 3){
                findProduct(inventory, scanner);
            } else if (input == 4){
                listAllProducts(inventory);
            } else if (input == 5){
                createOrder(orderManager, scanner);
            } else if (input == 6){
                viewOrders(orderManager);
            } else if(input ==7){
                processOrder(orderManager,scanner);
            } else if (input == 8){
                generateReports(inventory,orderManager);
            } else if (input == 9){
                active = false;
            } else{
                System.out.println("Error: Please Enter 1-9");
            }
        }
    }
    //add product 
    public static void addProduct(ProductInventory inventory, Scanner scanner){
        System.out.println("ProductID?");
        String id = scanner.next();
        System.out.println("Name?");
        String name = scanner.next();
        System.out.println("Category?");
        String category = scanner.next();
        System.out.println("Price?");
        double price = scanner.nextDouble();
        System.out.println("Quantity?");
        int quanity = scanner.nextInt();
        System.out.println("Supplier?");
        String supplier = scanner.next();
        inventory.addProduct(new Product(id, name, category, price, quanity, supplier)); 
        System.out.println("Finished");
    }

    //remove product
    public static void removeProduct(ProductInventory inventory, Scanner scanner){
        System.out.println("Product ID");
        String id = scanner.next();
        if (inventory.removeProduct(id)){
            System.out.println("Removed");
        }else {
            System.out.println("Product Not Found");
        }
    }

    //find all product
    public static void findProduct(ProductInventory inventory, Scanner scanner){
        System.out.println("Product ID?");
        String id = scanner.next();
        Product product = inventory.findProduct(id);
        if (product != null){
            System.out.println(product);
        }else {
            System.out.println("Product Not Found");
        }
    }

    //list all products
    public static void listAllProducts(ProductInventory inventory){
        inventory.printAllProducts();
    }

     //view order
    public static void viewOrders(OrderManager orderManager){
        orderManager.printAllOrders();
    }
    //create order
    public static void createOrder(OrderManager orderManager, Scanner scanner){
        System.out.println("Order ID?");
        String orderId = scanner.next();
        System.out.print("Customer Name?");
        String customerName = scanner.next();
        System.out.print("Date (YYYY-MM-DD)?");
        String date = scanner.next();
        Order order = new Order(orderId, customerName, date);
        System.out.print("How many items?");
        int numItems = scanner.nextInt();
            for (int i = 0; i < numItems; i++) {
                System.out.print("Product ID?");
                String productId = scanner.next();
                System.out.print("Product Name? ");
                String productName = scanner.next();
                System.out.print("Quantity? ");
                int quantity = scanner.nextInt();
                System.out.print("Unit Price? ");
                double price = scanner.nextDouble();
                order.addItem(new OrderItem(productId, productName, quantity, price));
            }
        orderManager.addOrder(order);
        System.out.println("Order Created");
    }
    // process order
    public static void processOrder(OrderManager orderManager, Scanner scanner){
        System.out.println("Order ID?");
        String orderId = scanner.next();
        System.out.println("Status? (Pending/Processing/Shipped/Delivered/Cancelled)");
        String status = scanner.next();
        Order order = orderManager.findOrder(orderId);
            if (order != null) {
                order.updateStatus(status);
                System.out.println("Status updated");
            } else { 
                System.out.println("Order Not Found");
            }    
    }

    // report
    public static void generateReports(ProductInventory inventory, OrderManager orderManager){
        inventory.printCapacityReport();
        System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue() + "\n" +
                            "Total orders: " + orderManager.getOrderCount() + "\n" +
                            "Total revenue: $ " + orderManager.getTotalRevenue());
    }

}
