package LAB2;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import LAB2.Interface.IDateFormatter;

import java.util.Date;

public class Start {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) throws Exception {
        // Инициализация CDI-контейнера Weld
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        try {
            // Получение экземпляра форматтера даты через CDI
            IDateFormatter dateFormatter = container.select(IDateFormatter.class).get();

            // Получение текущей даты
            Date currentDate = new Date();

            // Форматирование текущей даты
            String formattedDate = dateFormatter.format(currentDate);

            // Вывод результата
            System.out.println("Текущая дата (форматированная): " + formattedDate);
        } finally {
            // Завершение работы CDI-контейнера
            weld.shutdown();
        }
    }
}
