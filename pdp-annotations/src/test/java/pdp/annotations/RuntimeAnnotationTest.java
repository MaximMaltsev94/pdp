package pdp.annotations;

import org.junit.Test;
import pdp.annotations.factory.InjectIntegerAnnotationsProceedingFactory;
import pdp.annotations.objects.AnnotatedPerson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RuntimeAnnotationTest {

    InjectIntegerAnnotationsProceedingFactory factory = new InjectIntegerAnnotationsProceedingFactory();

    @Test
    public void testGetClass() {
        Object obj = new AnnotatedPerson("Aleh");
        assertEquals(AnnotatedPerson.class, obj.getClass());
    }

    @Test
    public void annotatedPersonTest() throws InstantiationException, IllegalAccessException {
        AnnotatedPerson person = factory.getObject(AnnotatedPerson.class);
        assertTrue(person.getAge() >= 18 && person.getAge() < 30);
        assertTrue(person.getHeight() >= 155 && person.getHeight() < 190);
        assertEquals("unnamed", person.getName());

    }
}
