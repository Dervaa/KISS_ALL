package LAB3.Util;

import LAB3.Qualifiers.AddedText;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class TextStorage {

    private StringBuilder texts = new StringBuilder(); // Для накопления текста

    @Inject
    @AddedText
    private Event<String> textAddedEvent;

    public void addText(String text) {
        if (texts.length() > 0) {
            texts.append(" "); // Добавляем пробел между текстами
        }
        texts.append(text); // Добавляем новый текст к накопленному
        System.out.println("Текущий текст: " + texts);

        textAddedEvent.fire(texts.toString()); // Генерируем событие с накопленным текстом
    }

    public String getAccumulatedText() {
        return texts.toString();
    }
}
