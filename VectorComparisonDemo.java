
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class VectorComparisonDemo {
    public static void main(String[] args) {
        Vector<Product> vector = new Vector<>();
        ArrayList<Product> arrayList = new ArrayList<>();
        
        //time to add 10k product
        Runtime runtime = Runtime.getRuntime(); // used for memory

        //vector 
        runtime.gc();
        long beforeVector = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();
        for (int i =0; i < 10000; i++){
            vector.add(new Product("Test " + i, "Product" + i, "Category", 2.67, 67, "Supplier"));
        }
        long vectorTime = System.nanoTime() - start; // calculate time to finish
        long vectorMemory = (runtime.totalMemory() - runtime.freeMemory() - beforeVector); // calculate total memory

        //arraylist
        runtime.gc();
        long beforeArrayList = runtime.totalMemory() - runtime.freeMemory();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(new Product("Test " + i, "Product" + i, "Category", 2.67, 67, "Supplier"));            
        }
        long arrayListTime = System.nanoTime() - start;
        long arrayListMemory = (runtime.totalMemory() - runtime.freeMemory()) - beforeArrayList;

        // access 1k random elements
        Random random = new Random();

        runtime.gc();
        long beforeVectorAccess = runtime.totalMemory() - runtime.freeMemory();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            vector.get(random.nextInt(10000));
        }
        long vectorAccessTime = System.nanoTime() - start;
        long vectorAccessMemory = (runtime.totalMemory() - runtime.freeMemory()) - beforeVectorAccess;

        runtime.gc();
        long beforeArrayListAccess = runtime.totalMemory() - runtime.freeMemory();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(random.nextInt(10000));
        }
        long arrayListAccessTime = System.nanoTime() - start;
        long arrayListAccessMemory = (runtime.totalMemory() - runtime.freeMemory()) - beforeArrayListAccess;

        //printing system report
        System.out.println("Comparison Report" + "\n" +
                            "Time to add 10,000 products:"+ "\n" +
                            "Vector: " + vectorTime + " ns" + "\n" +
                            "ArrayList: " + arrayListTime + " ns" + "\n" +
                            "Memory to add 10,000 products:" + "\n" + 
                            "Vector: " + vectorMemory + " bytes" + "\n" +
                            "ArrayList: " + arrayListMemory + " bytes" + "\n" +
                            "Time to access 1,000 random elements:" + "\n" +
                            "Vector: " + vectorAccessTime + " ns" + "\n" +
                            "ArrayList: " + arrayListAccessTime + " ns" + "\n" +
                            "Memory to access 1,000 random elements: " + "\n" +
                            "Vector: " + vectorAccessMemory + " bytes" + "\n" +
                            "ArrayList: " + arrayListAccessMemory + " bytes");

        // I've notice using ArrayList overall seems to be better.
        //For adding 10,000 products, ArrayList was faster by about 6x,
        // For accessing 1,000 random elements, Vector was slightly faster 
        // but I think overall ArrayList is best for using when adding large amount of data
        // vector for when accessing random elements.
        // Regarding memory vector seems to use a lot more compared to arrayList.

    }
}
