import java.util.ArrayList;
import java.util.HashSet; // unused import
import java.util.LinkedList; // unused import

public class EveryThing {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("GPT");

        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += list.get(i); // string concatenation in loop
        }

        int x; // unused variable

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + j); // nested loop
            }
        }

        int limit = 1000; // magic number

        switch (limit) {
            case 1000:
            case 2000:
            case 3000:
            case 4000:
            case 5000:
            case 6000:
                System.out.println("Limit matched.");
                break;
        }

        System.out.println(factorial(5)); // recursive call
    }

    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n-1);
    }
}