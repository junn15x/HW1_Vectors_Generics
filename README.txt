Product.java
    It has six fields:
        productid,name,category, price, quantityinStock and supplier
    The constructor takes all six parameters and assign them to the fields. We also 
    have the getters and setters for each field. 

    ToString returns a formatted string when printing the product datas.
    equals() takes two product by their product ID and compares them.
    hashCode required when using @Override for equals(). 


ProductInventory.java
    In this class we are managing all the products using a Vector. 
    addProduct checks for error such as null and duplicate productid. If no error it will
    add the product to the products Vector.

    removeProduct will loop through using the productId to check for any matches, if any match are found
    it will remove it and return true. if no match it will return false;
    findProduct will loop through using productId, returns the product if found, if not then return null;
    getProductsByCategory and quantityinStock both creates a new empty Vector, looping through and add if it match
    that category or checks if the quantityinStock is below the threshold. 
    getTotalInventoryValue goes through every product and does price * quantity, adding result to the total and returns 
    the final amount.
    updateStock find the product's by its Id and then updates the quantity change. Ex. subtract or adds to the amount of stocks.
    getTotalProducts returns the size of the Vector
    printAllProducts uses the toString to print all the products
    printCapacityInfo, printCapacityReport, optimizeCapacity, ensureCapacity all were used to get info regarding the Vector or used to
    optimize the memory.
    printProductUsingEnumeration uses the Enumeration method (old) to run and print instead of using a regular loop 

VectorComparisonDemo
    In this class we are comparing Vector and ArrayList by measuring the memory used and time it takes to accomplished
    the task. I used System.nanoTime to help calculate the time it. For memory I used runtime.gc 
    For the 10,000 products ArrayList was faster
    for the 1,000 random elements results were similar


OrderItem.java
    It is similar to Product instead it takes the fields productId, productName, quantity, unitPrice and subtotal;
    calculateSubtotal will update subtotal if any changes were made.

Order.java
    Order takes the field orderID,customerName, orderDate, orderStatus.
    I added a handle case for orderDate to ensure it only takes the date in a YYYY-MM-DD format using regex. 
    addItems, removeItems, and findItems method adds an order, removes or finds an product using productId.
    calculateTotal will find the total order by adding all items.
    getTotalItems will get the total number of items in the order 
    updateStatus ensures that the new status will accept only Pending,Processing,shipped, delivered or canceled.
    printOrder and toString is used to print the info
    getItems will return a copy of the items Vector.

OrderManger.java
    addOrder adds an order to the Vector
    findOrder goes through and search using orderID, returns if found, else returns null
    getOrdersByStatus and getOrdersByCusomter both will make a new vector and then loop through returns the status or customerName that matches
    getTotalRevenue goes through by looping and adds the total that have a "Delivered" status only
    cancelOrder will change the status with updateStatus with canceled
    getPendingOrder uses getOrdersByStatus to return everything with "pending"
    printAllOrders will print using toString as it loops.
    getOrderCount returns the size.

VectorUtils.java
    We are using generic static methods. 
        swap will swap the elements using a temp variable.
        findMax uses a compareTo to compare each elements to find the largest max.
        countMatches uses equals to count how many elements matches the value.
        filterProducts loops through and returns elements that matches the condition.
        sumNumbers will take any number, it will loop through and converts both 
        elements into double and adds it to the total.
        averageNumbers does the same but instead divides the total with the size of the Vector.

GenericContainter.java
    In this we are using wrappers with generics so this will work with any kind of strings, int 
        add will add item to the vector
        get returns the item 
        remove will remove item
        size will return the size
        getAll will return cpies of all items
        clear will clear all items
        contains check if it contains an item
        addAll add everything from another vector

InventorySystemMain.java
    this is the interactie menu, we will be using Scanner to allow for user input. We have a while loop to ensure that
    the menu will continue to run until the user press 9 (exit). The user is given options 1-9, each will call a different 
    helper method. 

How to complile/ run
    I'm not exactly sure what this is asking but to run 
    Part 1-4

    javac *.java
    java Main

    Part 5 
    javac *.java
    java InventorySystemMain

Assumptions
    I tried my best to follow exactly what the instructions tell me to do since I often overthink things and make 
    it more complicated. I assumed certain formats were required to be structured a certain way. 

Challenges
    I think my biggest challenge was writing the codes with newer materials we just learned, I had to use chat to help me generate 
    a skeleton with some hints to help me get it done. I think this could be resolve as I write more and get more used to 
    it. I also had a hard time making sure everything had proper error handling.

What have I learn about Vectors and generics:
Before this class I didn't have any knowledge on vectors, I did learn a little bit of generics but it was not that much.
So everything here is pretty new to me but I did learn a lot after working through all the exercise and the hw. 







