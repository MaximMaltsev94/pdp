package pdp.annotations;

public class AnnotationsMain {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new AnnotationsMain().getGreeting());
    }
}
