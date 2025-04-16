public class StringConcatenation {  
    public static void main(String[] args) {  
        String output = "";  
        for (int i = 0; i < 100; i++) {  
            output += i + ",";  
        }  
        System.out.println(output);  
    }  
}