import java.nio.file.*;  
import java.io.IOException;  
import java.util.Scanner;  

public class Main {  
    public static void main(String[] args) {  
        SnippetManager manager = new SnippetManager();  
        Scanner sc = new Scanner(System.in);  
        int choice;  

        do {  
            System.out.println("\nCode Snippet Manager");  
            System.out.println("1. Add Snippet from File");  
            System.out.println("2. View Snippet");  
            System.out.println("3. Update Snippet");  
            System.out.println("4. Delete Snippet");  
            System.out.println("5. List All Snippets");  
            System.out.println("0. Exit");  
            System.out.print("Enter your choice: ");  
            
            choice = sc.nextInt();  
            sc.nextLine(); // Consume newline  
            
            switch (choice) {  
                case 1:  
                    System.out.print("Enter snippet title: ");  
                    String title = sc.nextLine();  
                    System.out.print("Enter path to Java file: ");  
                    String filePath = sc.nextLine();  
                    
                    try {  
                        String code = new String(Files.readAllBytes(Paths.get(filePath)));  
                        manager.createSnippet(title, code);  
                    } catch (IOException e) {  
                        System.out.println("Error reading file: " + e.getMessage());  
                    }  
                    break;  
                    
                case 2:  
                    System.out.print("Enter snippet ID: ");  
                    manager.readSnippet(sc.nextInt());  
                    sc.nextLine();  
                    break;  
                    
                case 3:  
                    System.out.print("Enter snippet ID to update: ");  
                    int updateId = sc.nextInt();  
                    sc.nextLine();  
                    System.out.print("Enter path to new Java file: ");  
                    String newFilePath = sc.nextLine();  
                    
                    try {  
                        String newCode = new String(Files.readAllBytes(Paths.get(newFilePath)));  
                        manager.updateSnippet(updateId, newCode);  
                    } catch (IOException e) {  
                        System.out.println("Error reading file: " + e.getMessage());  
                    }  
                    break;  
                    
                case 4:  
                    System.out.print("Enter snippet ID to delete: ");  
                    manager.deleteSnippet(sc.nextInt());  
                    sc.nextLine();  
                    break;  
                    
                case 5:  
                    manager.listAllSnippets();  
                    break;  
                    
                case 0:  
                    System.out.println("Exiting...");  
                    break;  
                    
                default:  
                    System.out.println("Invalid choice. Try again.");  
            }  
        } while (choice != 0);  
        
        sc.close();  
    }  
}  