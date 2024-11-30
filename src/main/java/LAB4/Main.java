package LAB4;

import LAB4.Model.CodeValidatedStation;
import LAB4.Model.XMLValidatedStation;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Создаем фабрику валидатора для Hibernate Validator
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        // Создаем объект для валидации через XML (XMLValidatedStation)
        XMLValidatedStation xmlStation = new XMLValidatedStation("Московская станция","MSK431", 5, 500);
        System.out.println("Валидация XMLValidatedStation:");
        validateAndPrint(validator, xmlStation);

        // Создаем объект для валидации через аннотации (CodeValidatedStation)
        CodeValidatedStation codeStation = new CodeValidatedStation("Лондонская станция","1234", 11, 100); // Некорректное имя и номер
        System.out.println("\nВалидация CodeValidatedStation:");
        validateAndPrint(validator, codeStation);
    }

    // Метод для валидации и вывода ошибок
    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object); // Валидируем объект
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                // Выводим ошибки с указанием поля и сообщения
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
