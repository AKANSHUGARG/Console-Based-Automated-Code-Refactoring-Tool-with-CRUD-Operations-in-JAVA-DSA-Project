public class Recursion {  
    public int factorial(int n) {  
        if (n <= 1) return 1;  
        return n * factorial(n-1);  // Recursive call  
    }  
}  