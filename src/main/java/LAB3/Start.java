package LAB3;

import LAB3.Util.TextStorage;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Start {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        try {
            TextStorage textStorage = container.select(TextStorage.class).get();
            textStorage.addText("Hello, CDI Events!");
        } finally {
            weld.shutdown();
        }
    }
}