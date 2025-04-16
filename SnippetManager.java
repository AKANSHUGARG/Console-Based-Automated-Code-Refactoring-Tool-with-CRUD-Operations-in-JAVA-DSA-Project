import java.util.*;

public class SnippetManager {
    private Map<Integer, CodeSnippet> snippets = new HashMap<>();
    private int currentId = 1;
    private CodeAnalyzer analyzer = new CodeAnalyzer();

    public void createSnippet(String title, String code) {
        CodeSnippet snippet = new CodeSnippet(currentId++, title, code);
        snippets.put(snippet.getId(), snippet);
        System.out.println("Snippet added with ID: " + snippet.getId());
    }

    public void readSnippet(int id) {
        if (snippets.containsKey(id)) {
            CodeSnippet snippet = snippets.get(id);
            System.out.println("Title: " + snippet.getTitle());
            System.out.println("Code:\n" + snippet.getCode());
            List<RefactorSuggestion> suggestions = analyzer.analyze(snippet.getCode());
            for (RefactorSuggestion s : suggestions) {
                s.display();
            }
        } else {
            System.out.println("Snippet not found.");
        }
    }

    public void updateSnippet(int id, String newCode) {
        if (snippets.containsKey(id)) {
            CodeSnippet snippet = snippets.get(id);
            snippet.setCode(newCode);
            System.out.println("Snippet updated.");
        } else {
            System.out.println("Snippet not found.");
        }
    }

    public void deleteSnippet(int id) {
        if (snippets.remove(id) != null) {
            System.out.println("Snippet deleted.");
        } else {
            System.out.println("Snippet not found.");
        }
    }

    public void listAllSnippets() {
        for (CodeSnippet s : snippets.values()) {
            System.out.println(s.getId() + ": " + s.getTitle());
        }
    }
}