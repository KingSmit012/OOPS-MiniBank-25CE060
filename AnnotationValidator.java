
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.MaxLength;
import annotation.Positive;

public class AnnotationValidator {

    public static String[] validate(Object obj) {

        if (obj == null) {
            return new String[]{"Object cannot be null."};
        }

        List<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {
                // Validate @Positive fields.
                if (field.isAnnotationPresent(Positive.class)) {

                    Object value = field.get(obj);
                    Positive annotation =
                            field.getAnnotation(Positive.class);

                    if (!(value instanceof Number)
                            || ((Number) value).longValue() <= 0) {

                        errors.add(
                                field.getName() + " "
                                        + annotation.message()
                        );
                    }
                }

                // Validate @MaxLength fields.
                if (field.isAnnotationPresent(MaxLength.class)) {

                    Object value = field.get(obj);
                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    if (value instanceof String
                            && ((String) value).length()
                                    > annotation.value()) {

                        errors.add(
                                field.getName()
                                        + " must have at most "
                                        + annotation.value()
                                        + " characters"
                        );
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add(
                        "Unable to validate field "
                                + field.getName()
                );
            }
        }

        return errors.toArray(new String[0]);
    }
}
