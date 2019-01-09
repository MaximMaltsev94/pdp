package pdp.annotations;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnnotationsTest {
    @Test
    public void testAppHasAGreeting() {
        AnnotationsMain classUnderTest = new AnnotationsMain();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
