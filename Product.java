

public class Product {
    private String productId; 
    private String name; 
    private String category; 
    private String supplier;
    private double price;
    private int quantityInStock;

        // Constructors
        public Product(String productId, String name, String category, double price, int quantityInStock, String supplier){
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.quantityInStock = quantityInStock;
            this.price = price;
            this.supplier = supplier;
        }

        // Getters
        public String getProductId(){
            return productId;
        }
        public String getName(){
            return name;
        }
        public String getCategory(){
            return category;
        }
        public double getPrice(){
            return price;
        }
         public int getQuantityInStock(){
            return quantityInStock;
         }
        public String getSupplier(){
            return supplier;
        }
        
        //Setters

        public void setProductId(String productId){
            this.productId = productId;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setCategory(String category){
            this.category = category;
        }
        public void setPrice(double price){
            this.price = price;
        }
        public void setQuantityInStock(int quantityInStock){
            this.quantityInStock = quantityInStock;
        }
        public void setSupplier(String supplier){
            this.supplier = supplier;
        }
    
        //toString
        @Override
        public String toString(){
            return "ProductId: " + productId + "\n" + 
                   "Name: " + name + "\n" +
                   "Category: " + category + "\n" +
                   "Price: " + price + "\n" +
                   "QuantityInStock: " + quantityInStock + "\n" +
                   "Supplier: " + supplier;
        }

        //Compare
        @Override
        public boolean equals( Object obj){
            Product that = (Product) obj;
            return this.productId.equals(that.productId);
        }

        //hashCode
        @Override
        public int hashCode(){
            return productId.hashCode();
        }
}
