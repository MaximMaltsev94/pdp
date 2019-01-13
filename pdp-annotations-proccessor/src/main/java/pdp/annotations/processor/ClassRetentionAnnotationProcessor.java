package pdp.annotations.processor;

import pdp.annotations.custom.NoMoreThanFourFields;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes({"pdp.annotations.custom.NoMoreThanFourFields"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ClassRetentionAnnotationProcessor extends AbstractProcessor {

    private ProcessingEnvironment processingEnvironment;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        processingEnvironment = processingEnv;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<TypeElement, Long> methodsCountForType = roundEnv.getElementsAnnotatedWith(NoMoreThanFourFields.class).stream()
                .filter(TypeElement.class::isInstance)
                .map(TypeElement.class::cast)
                .collect(Collectors.toMap(e -> e, e -> e.getEnclosedElements().stream().filter(VariableElement.class::isInstance).count()));

        methodsCountForType.forEach((key, value) -> {
            if (value > 5) {
                processingEnvironment.getMessager().printMessage(
                        Diagnostic.Kind.ERROR,
                        String.format("Class %s annotated with @NoMoreThanFourFields, but has %d fields", key.getSimpleName(), value));
            }
        });
        return true;
    }
}
