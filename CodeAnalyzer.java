import java.util.*;

public class CodeAnalyzer {
    public List<RefactorSuggestion> analyze(String code) {
        List<RefactorSuggestion> suggestions = new ArrayList<>();

        // 1. Detect nested loops
        if (code.contains("for") && code.indexOf("for", code.indexOf("for") + 1) != -1) {
            suggestions.add(new RefactorSuggestion(
                "Nested loop detected",
                "Consider reducing time complexity using sorting, hashing, or memoization."
            ));
        }

        // 2. Detect inefficient .contains() usage on ArrayList
        if (code.contains("ArrayList") && code.contains(".contains(")) {
            suggestions.add(new RefactorSuggestion(
                "Inefficient lookup in ArrayList",
                "Use HashSet instead of ArrayList for faster lookups (O(1) vs O(n))."
            ));
        }

        // 3. Detect String concatenation in loops
        if (code.contains("for") && code.contains("+=") && code.contains("String")) {
            suggestions.add(new RefactorSuggestion(
                "String concatenation in loop",
                "Use StringBuilder instead of '+' in loops to improve performance."
            ));
        }

        // 4. Detect unused variables
        if (code.matches(".int\\s+\\w+\\s;.") && !code.matches(".\\w+\\s*=.*")) {
            suggestions.add(new RefactorSuggestion(
                "Possibly unused variable",
                "Check for declared but unused variables to reduce memory usage."
            ));
        }

        // 5. Detect magic numbers
        if (code.matches(".[^\\w](\\d{2,})[^\\w].")) {
            suggestions.add(new RefactorSuggestion(
                "Magic number detected",
                "Replace hard-coded numbers with named constants for better readability and maintainability."
            ));
        }

        // 6. Detect recursion
        if (code.contains("return") && code.contains("(") && code.contains(")")) {
            String[] lines = code.split("\n");
            for (String line : lines) {
                if (line.trim().startsWith("return") && line.contains("(") && line.contains(")")) {
                    String[] words = line.split("[^a-zA-Z0-9_]");
                    for (String word : words) {
                        if (!word.isBlank() && code.contains("void " + word + "(")) {
                            suggestions.add(new RefactorSuggestion(
                                "Recursive call detected",
                                "Ensure base condition is present and consider converting to iterative if stack overflow is a risk."
                            ));
                            break;
                        }
                    }
                }
            }
        }

        // 7. Detect large switch-case blocks
        if (code.contains("switch") && code.split("case").length > 5) {
            suggestions.add(new RefactorSuggestion(
                "Large switch-case block",
                "Consider using polymorphism or a lookup table for better scalability."
            ));
        }

        // 8. Detect unused imports
        String[] lines = code.split("\n");
        for (String line : lines) {
            if (line.startsWith("import ")) {
                String imported = line.replace("import", "").replace(";", "").trim();
                String simpleName = imported.substring(imported.lastIndexOf('.') + 1);

                // Check if the imported class name appears in code (excluding the import itself)
                if (!code.replace(line, "").contains(simpleName)) {
                    suggestions.add(new RefactorSuggestion(
                        "Unused import: " + imported,
                        "Remove unused import to clean up the code."
                    ));
                }
            }
        }

        return suggestions;
    }
}