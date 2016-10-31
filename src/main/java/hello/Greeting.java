package hello;

/**
 * Created by seven on 30.10.2016.
 */
public class Greeting {
    private long id;
    private String content;
    private ProField proField;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProField getProField() {
        return proField;
    }

    public void setProField(ProField proField) {
        this.proField = proField;
    }
}
