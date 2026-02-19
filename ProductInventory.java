
import java.util.Enumeration;
import java.util.Vector;

public class ProductInventory{
    //Check for Duplicates by productId

    private Vector<Product> products = new Vector<>();
        public void addProduct(Product product){
            if (product == null){
                System.out.println("Error: Null");
                return;
            }
            for (int i =0; i < products.size(); i++) {
                if (products.get(i).getProductId().equals(product.getProductId())){
                    System.out.println("Error: Duplicates");
                    return;
                }
            }
        products.add(product);
    }
    
    //remove product via ID

    public boolean removeProduct(String productId){
        if (productId == null || productId.isEmpty()){
            return false;
        }
        for (int i=0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(productId)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    // find and return product

    public Product findProduct(String productId){
        if (productId == null || productId.isEmpty()){
            System.out.println("Error: Null");
            return null;
        }
        for (int i=0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(productId)){
                return products.get(i);
            }
        }
        return null;
    }

    // return vector of product in category
    
    public Vector<Product> getProductsByCategory(String category){
        Vector<Product> result = new Vector<>();
        if (category == null || category.isEmpty()){
            System.out.println("Error: null");
            return null;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().equals(category)) {
                result.add(products.get(i));
            }
        }
        return result;
    }
        // checks threshold
    public Vector<Product> getLowStockProducts(int threshold){
        Vector<Product> result = new Vector<>();
        if (threshold < 0){
            System.out.println("Error: threshold negative");
            return result;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getQuantityInStock() < threshold) {
                result.add(products.get(i));
            }
        }
        return result;
    }

    // get total value of product
    public double getTotalInventoryValue(){
        double total= 0;
        for (int i = 0; i < products.size(); i++) {
            total += (products.get(i).getPrice() * products.get(i).getQuantityInStock());
        }
        return total;
    }

    //update stocks
    public void updateStock(String productId, int quantityChange){
        if (productId == null || productId.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)){
                    if (products.get(i).getQuantityInStock() + quantityChange < 0) {
                        System.out.println("Error: No Stock");
                        return;
                    }
                products.get(i).setQuantityInStock(products.get(i).getQuantityInStock() + quantityChange);
            }
        }
    }

    //use toString to print product
    public void printAllProducts(){
        if (products.isEmpty()){
            System.out.println("Error: null");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
    
    // return number of products
    public int getTotalProducts(){
        return products.size();
    }

    // print current size + capacity of vector

    public void printCapacityInfo(){
        System.out.println("Current Size: " + products.size() + "\n" +
                            "Current Capacity: " + products.capacity());
    }

    //reduce size capcity to match size
    public void optimizeCapacity(){
        products.trimToSize();
    }

    //ensure it has at least minCapacity
    public void ensureCapacity(int minCapacity){
        products.ensureCapacity(minCapacity);
    }
    
    //print detailed capcity info
    public void printCapacityReport(){
        System.out.println("Current Size: " + products.size() + "\n" +
                            "Current Capacity: " + products.capacity() + "\n" +
                            "Capacity utilization percentage: " + ((double) products.size()/products.capacity() * 100) + "\n" +
                            "How many elements can be added before resize: " + (products.capacity() - products.size()));
    }
    
    //enumeration
    public void printProductsUsingEnumeration(){
        Enumeration<Product> e = products.elements();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
    // From what I found after looking it up, enumeration is legacy because it's from java 1.0 
    // it seems to have it's limitations compared to iterator. For example, the method names are
    // longer and you cant remove elements; it also only works with vectors and hashtable. Compare to
    // Iterator which seems to be the modern verison of enumeration, you are able to remove elements 
    //during iteration.
    //You only use enumeration when working with legacy code that requires it. Iteration for all modern codes unless stated.
}