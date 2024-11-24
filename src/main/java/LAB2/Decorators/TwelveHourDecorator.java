package LAB2.Decorators;

import LAB2.Interface.IDateFormatter;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Date;

@Decorator
public class TwelveHourDecorator implements IDateFormatter {

    @Inject
    @Delegate
    private IDateFormatter dateFormatter;

    public TwelveHourDecorator() {
        System.out.println("TwelveHourDecorator instance created");
    }

    @Override
    public String format(Date date) {
        String formattedDate = dateFormatter.format(date);
        String[] parts = formattedDate.split(" ");
        String[] timeParts = parts[parts.length - 1].split("\\.");

        // Преобразование времени
        int hours = Integer.parseInt(timeParts[0]);
        String period = hours >= 12 ? "PM" : "AM";
        hours = hours % 12 == 0 ? 12 : hours % 12;
        timeParts[0] = String.valueOf(hours);

        parts[parts.length - 1] = String.join(":", timeParts) + " " + period;
        return String.join(" ", parts);
    }
}
