public class RefactorSuggestion {
    private String issue;
    private String suggestion;

    public RefactorSuggestion(String issue, String suggestion) {
        this.issue = issue;
        this.suggestion = suggestion;
    }

    public void display() {
        System.out.println("Issue: " + issue);
        System.out.println("Suggestion: " + suggestion);
    }
}