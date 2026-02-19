import java.util.Vector;

public class Main {
    public static void main(String[] args) {
    ProductInventory inventory = new ProductInventory();
    
    //part 1.2

    inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
    inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
    inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));

    inventory.printAllProducts();
    inventory.printCapacityInfo();

    Vector<Product> electronics = inventory.getProductsByCategory("Electronics");
    System.out.println("Electronics: " + electronics.size());

    Vector<Product> lowStock = inventory.getLowStockProducts(10);
    System.out.println("Low stock items: " + lowStock.size());

    System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue() + "\n");

    //part 2.3
    System.out.print("----------------Part 2.3-----------------" + "\n");
    OrderManager orderManager = new OrderManager();

    Order order1 = new Order("O001", "Alice", "2024-01-15");
    order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
    order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
    orderManager.addOrder(order1);

    Order order2 = new Order("O002", "Bob", "2024-01-16");
    order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
    orderManager.addOrder(order2);
    
    order1.updateStatus("Delivered"); // test value
    System.out.println("Total revenue: $" + orderManager.getTotalRevenue() + "\n");
    
    //part 3.1

    System.out.print("----------------Part 3.1-----------------" + "\n");
    inventory.optimizeCapacity();
    inventory.ensureCapacity(50);
    inventory.printCapacityReport();

    //part 4.2
    System.out.print("----------------Part 4.2-----------------" + "\n");

    GenericContainer<String> stringContainer = new GenericContainer<>();
    stringContainer.add("Hello");
    stringContainer.add("World");

    GenericContainer<Integer> intContainer = new GenericContainer<>();
    intContainer.add(10);
    intContainer.add(20);

    GenericContainer<Product> productContainer = new GenericContainer<>();
    productContainer.add(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));
    
    System.out.println(stringContainer.getAll());
    System.out.println(intContainer.getAll());
    System.out.println(productContainer.getAll());

    System.out.print("----------------Part 4.3-----------------" + "\n");

    Vector<Integer> ints = new Vector<>();
    ints.add(10);
    ints.add(20);
    ints.add(30);
    System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
    System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0

    //  error testing
    System.out.print("----------------Error Test-----------------" + "\n");
    inventory.addProduct(null);
    inventory.removeProduct("INVALID10!");
    inventory.addProduct(new Product("P001", "Laptop", "Electronics", -2.67, -12, "TechCorp"));
    order1.updateStatus("TBD");
    System.out.println("Find Product: " + inventory.findProduct("INVALID132!")); 
    }
}