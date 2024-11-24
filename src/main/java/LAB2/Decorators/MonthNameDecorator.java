package LAB2.Decorators;

import LAB2.Interface.IDateFormatter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Date;

@Decorator
public class MonthNameDecorator implements IDateFormatter {

    @Inject
    @Delegate
    private IDateFormatter dateFormatter;

    public MonthNameDecorator() {
        System.out.println("MonthNameDecorator instance created");
    }

    @Override
    public String format(Date date) {
        // Получение базового форматирования
        String formattedDate = dateFormatter.format(date);
        System.out.println("MonthNameDecorator applied");
        System.out.println("Base formatted date: " + formattedDate);

        // Список названий месяцев
        String[] monthNames = {"января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"};

        // Разделяем дату на части: dd.MM.yyyy HH.mm.ss
        String[] parts = formattedDate.split(" "); // ["dd.MM.yyyy", "HH.mm.ss"]

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid date-time format: " + formattedDate);
        }

        String datePart = parts[0]; // "dd.MM.yyyy"
        String timePart = parts[1]; // "HH.mm.ss"

        // Обработка части даты
        String[] dateParts = datePart.split("\\."); // ["dd", "MM", "yyyy"]
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Invalid date format: " + datePart);
        }

        String day = dateParts[0]; // День
        int monthIndex = Integer.parseInt(dateParts[1]) - 1; // Номер месяца (0-based)
        String month = monthNames[monthIndex]; // Название месяца
        String year = dateParts[2]; // Год

        // Собираем финальный формат
        return String.join(" ", day, month, year, timePart);
    }
}
