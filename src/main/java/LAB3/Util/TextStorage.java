package LAB3.Util;

import LAB3.Qualifiers.AddedText;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class TextStorage {

    @Inject
    @AddedText
    private Event<String> textAddedEvent;

    public void addText(String text) {
        System.out.println("Добавление текста: " + text);
        textAddedEvent.fire(text);
    }
}
