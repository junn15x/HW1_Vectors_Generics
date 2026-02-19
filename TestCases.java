import java.util.Vector;

public class TestCases {
    public static void main(String[] args) {

        // test product
        ProductInventory inventory = new ProductInventory();
        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp")); // duplicate
        inventory.removeProduct("P001");
        System.out.println("Total products: " + inventory.getTotalProducts());

        // teest for order
        Order order = new Order("O001", "Alice", "2024-01-15");
        order.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
        order.updateStatus("InvalidStatus"); // should not change
        System.out.println("Status: " + order.getOrderStatus()); // should be Pending
        System.out.println("Total: $" + order.calculateTotal()); // should be 999.99

        // testing generics for int
        Vector<Integer> ints = new Vector<>();
        ints.add(10); ints.add(20); ints.add(30);
        System.out.println("Sum: " + VectorUtils.sumNumbers(ints));
        System.out.println("Average: " + VectorUtils.averageNumbers(ints));
        System.out.println("Max: " + VectorUtils.findMax(ints));
        
        //testing generics for string 
        Vector<String> strings = new Vector<>();
        strings.add("Hello"); strings.add("Goodbye"); strings.add("idk");
        System.out.println("Max String: " + VectorUtils.findMax(strings));
        System.out.println("Count Hello: " + VectorUtils.countMatches(strings, "Hello"));


        // edge cases
        System.out.println("Empty average: " + VectorUtils.averageNumbers(new Vector<>()));
        inventory.addProduct(null);

        //capactiy
        inventory.optimizeCapacity();
        inventory.ensureCapacity(50);
        inventory.printCapacityReport();
    }
}