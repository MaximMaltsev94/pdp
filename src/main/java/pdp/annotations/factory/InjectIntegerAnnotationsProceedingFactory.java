package pdp.annotations.factory;

import pdp.annotations.custom.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InjectIntegerAnnotationsProceedingFactory {

    public <T> T getObject(Class<T> dataType) throws IllegalAccessException, InstantiationException {
        T result = dataType.newInstance();
        Stream.of(dataType.getDeclaredFields())
                .filter(isInjectIntegerAnnotationPresent)
                .forEach(field -> saveProceedInjectIntegerAnnotation(field, result));
        return result;
    }

    private Predicate<Field> isInjectIntegerAnnotationPresent = val -> val.isAnnotationPresent(InjectRandomInt.class);

    private <T> void saveProceedInjectIntegerAnnotation(Field field, T object) {
        try {
            proceedIntegerAnnotation(field, object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void proceedIntegerAnnotation(Field field, T object) throws IllegalAccessException {
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        field.setAccessible(true);
        field.set(object, nextRandomInt(annotation.min(), annotation.max()));
    }

    private Integer nextRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
