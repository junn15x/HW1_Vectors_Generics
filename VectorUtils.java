import java.util.Vector;

public class VectorUtils {

    //swap
    public static <T> void swap(Vector<T> vec, int index1, int index2) {
        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, temp);
    }
    
    //max
    public static <T extends Comparable<T>> T findMax(Vector<T> vec){
        T max = vec.get(0);
        for (int i = 1; i < vec.size(); i++) {
            if (vec.get(i).compareTo(max) > 0) {
                max = vec.get(i);
            }
        }
        return max;
    }

    // countMatches

    public static <T> int countMatches(Vector<T> vec, T target){
        int count = 0;
        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals(target))
                count++;
        }
        return count;
    }
    //filter
    public static <T> Vector<T> filterProducts(Vector<T> vec, T target) {
        Vector<T> result = new Vector<>();
        for (int i = 0; i < vec.size(); i++){
            if (vec.get(i).equals(target)){
                result.add(vec.get(i));
            }
        }
        return result; 
    }
    // sum
    public static <T extends Number> double sumNumbers(Vector<T> numbers){
        double total = 0;
        for (int i =0; i <numbers.size(); i++){
            total += numbers.get(i).doubleValue();
        }
        return total;
    }
    //average
    
    public static <T extends Number> double averageNumbers(Vector<T> numbers){
        double average = 0;
        if (numbers == null|| numbers.isEmpty()){
            return 0.0;
        }
        for (int i = 0; i < numbers.size(); i++) {
            average += numbers.get(i).doubleValue();
        }
        return average / numbers.size();
    }
}
