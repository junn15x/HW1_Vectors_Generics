public class OrderItem {
    private String productId;
    private String productName;
    private int quanity;
    private double unitPrice;
    private double subtotal;

    //constructors
    public OrderItem(String productId, String productName, int quanity, double unitPrice){
        this.productId = productId;
        this.productName = productName;
        this.quanity = quanity;
        this.unitPrice = unitPrice;
        this.subtotal = quanity * unitPrice;
    }

    //getters
    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public int getQuantity(){
        return quanity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public double getSubtotal(){
        return subtotal;
    }

    //setters
    public void setProductId(String productId){
        this.productId = productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setQuantity(int quanity){
        this.quanity = quanity;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    //toString
    @Override
    public String toString(){
        return "Product Id: " + productId + "\n" +
                "Product Name: " + productName + "\n" +
                "quantity: " + quanity + "\n" +
                "Unit Price: " + unitPrice + "\n" +
                "Subtotal: " + subtotal;
    }

    //calculates & update subtotal
    double calculateSubtotal(){
        subtotal = unitPrice * quanity;
        return subtotal;
    }
}
