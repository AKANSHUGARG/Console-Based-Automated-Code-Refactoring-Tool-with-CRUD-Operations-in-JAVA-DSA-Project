import java.util.ArrayList;  

public class ArrayListContains {  
    public static void main(String[] args) {  
        ArrayList<String> list = new ArrayList<>();  
        list.add("apple");  
        list.add("banana");  
        
        if (list.contains("banana")) {  // Inefficient lookup  
            System.out.println("Found banana");  
        }  
    }  
}  