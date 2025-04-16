public class CodeSnippet {  
    private int id;  
    private String title;  
    private String code;  

    // Constructor  
    public CodeSnippet(int id, String title, String code) {  
        this.id = id;  
        this.title = title;  
        this.code = code;  
    }  

    // Getters  
    public int getId() {  
        return id;  
    }  

    public String getTitle() {  
        return title;  
    }  

    public String getCode() {  
        return code;  
    }  

    // Setters  
    public void setTitle(String title) {  
        this.title = title;  
    }  

    public void setCode(String code) {  
        this.code = code;  
    }  
}  