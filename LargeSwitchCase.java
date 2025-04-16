public class LargeSwitchCase {  
    public static void main(String[] args) {  
        int day = 3;  
        switch (day) {  
            case 1: System.out.println("Mon"); break;  
            case 2: System.out.println("Tue"); break;  
            case 3: System.out.println("Wed"); break;  
            case 4: System.out.println("Thu"); break;  
            case 5: System.out.println("Fri"); break;  
            case 6: System.out.println("Sat"); break;  
            case 7: System.out.println("Sun"); break;  // Large switch  
        }  
    }  
}  