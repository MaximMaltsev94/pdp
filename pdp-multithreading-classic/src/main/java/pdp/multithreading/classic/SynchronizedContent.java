package pdp.multithreading.classic;

public class SynchronizedContent {
    private String content;

    public String readContent() {
        return content;
    }

    public void writeContent(String content) {
        this.content = content;
    }

    public boolean equalTo(String other) {
        if(other == null || content == null) {
            return false;
        }
        return content.equals(other);
    }

    public boolean notEqualTo(String other) {
        return !equalTo(other);
    }

}
