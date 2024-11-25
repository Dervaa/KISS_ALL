package LAB3;

import LAB3.Util.TextStorage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        try {
            TextStorage textStorage = container.select(TextStorage.class).get();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Введите текст для добавления (или 'exit' для выхода):");
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                textStorage.addText(input); // Добавляем текст в TextStorage
            }

        } finally {
            weld.shutdown();
        }
    }
}
