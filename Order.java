import java.util.Vector;

public class Order {
    private Vector<OrderItem> items = new Vector<>();
    private String orderId;
    private String customerName;
    private String orderDate;
    private String orderStatus = "Pending";
    
    //constructor
    public Order(String orderId, String customerName, String orderDate){
        // \\d{4} = 4 digits \\d{2} = 2 digits
        if (orderDate == null || !orderDate.matches("\\d{4}-\\d{2}-\\d{2}")){ 
            System.out.print("Error: use YYYY-MM-DD");
            return;
        }
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    //getter
    public String getOrderId(){
        return orderId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getOrderDate(){
        return orderDate;
    }
    public String getOrderStatus(){
        return orderStatus;
    }
    //setter
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setOrderDate(String orderDate){
        this.orderDate = orderDate;
    }
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }

    //add items to order
    public void addItem(OrderItem item){
        if (item == null){
            System.out.println("Error: null");
            return;
        }
        items.add(item);
    }

    //remove item by productId
    public boolean removeItem(String productId){
        if (productId == null || productId.isEmpty()){
            return false;
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getProductId().equals(productId)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    // find item in order
    public OrderItem findItem(String productId){
        if(productId == null || productId.isEmpty()){
            System.out.println("Error: null");
            return null;
        }
        for (int i = 0; i < items.size(); i++){
            if(items.get(i).getProductId().equals(productId)){
                return items.get(i);
            }
        }
        return null;
    }

    //calculate total order value
    public double calculateTotal(){
        double total = 0;
        if (items == null || items.isEmpty()){
            System.out.println("Error: null");
            return 0;
        }
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getSubtotal();
        }
        return total;
    }

    //return total quanitity of all items
    public int getTotalItems(){
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getQuantity();
        }
        return total;
    }

    //update order status
    public void updateStatus(String newStatus){
        if (newStatus == null || newStatus.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        if (!newStatus.equalsIgnoreCase("Pending") &&
            !newStatus.equalsIgnoreCase("Processing") &&
            !newStatus.equalsIgnoreCase("Shipped") &&
            !newStatus.equalsIgnoreCase("Delivered") &&
            !newStatus.equalsIgnoreCase("Cancelled")) {
            System.out.println("Error: Status Issue");
            return;
        }
        orderStatus = newStatus;
    }
    @Override
    public String toString() {
    return "OrderId: " + orderId + "\n" +
           "Customer: " + customerName + "\n" +
           "Date: " + orderDate + "\n" +
           "Status: " + orderStatus + "\n" +
           "Total: $" + calculateTotal();
}

    //prints using toString 
    public void printOrder(){
        if (items.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    //return copy of items to vector
    public Vector<OrderItem> getItems(){
        return new Vector<>(items);
        
    }
}
