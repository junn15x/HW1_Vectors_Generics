
import java.util.Vector;

public class OrderManager {
    private Vector<Order> orders = new Vector<>();

    // add order

    public void addOrder(Order order){
        if (order == null){
            System.out.println("Error: null");
            return;
        }
        orders.add(order);
    }

    // find order by id
    public Order findOrder(String orderId){
        if (orderId == null || orderId.isEmpty()){
            System.out.println("Error: null");
            return null;
        }
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(orderId)){
                return orders.get(i);
            }
        }
        return null;
    }

    //return orders with specific status
    public Vector<Order> getOrdersByStatus(String status){
        if (status == null || status.isEmpty()){
            System.out.println("Error: null");
            return null;
        }
        Vector<Order> result = new Vector<>();
        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).getOrderStatus().equals(status)){
                result.add(orders.get(i));
            }         
        }
        return result;
    }

    //return customer's orders
    public Vector<Order> getOrdersByCustomers(String customerName){
        if (customerName == null || customerName.isEmpty()){
            System.out.println("Error: null");
            return null;
        }
        Vector<Order> results = new Vector<>();
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getCustomerName().equals(customerName)){
                results.add(orders.get(i));
            }
        }
        return results;
    }

    //calculate total revenue from all delivered orders
    public double getTotalRevenue(){
        double total =0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderStatus().equals("Delivered")) {
                total += orders.get(i).calculateTotal();
            }
        }
        return total;
    }

    //cancel orders / update status
    public void cancelOrders(String orderId){
        if (orderId == null || orderId.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        Order order = findOrder(orderId);
        if (order == null){
            System.out.println("Error: No order");
            return;
        }
        order.updateStatus(("Cancelled"));
    }

    //print all orders
    public void printAllOrders(){
        if (orders.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }
    }

    // return pending orders
    public Vector<Order> getPendingOrders(){    
            return getOrdersByStatus("Pending");
    }

    //return number of order
    public int getOrderCount(){
        return orders.size();
    }
}  
