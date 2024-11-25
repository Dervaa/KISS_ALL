package LAB3.Util;

import LAB3.Qualifiers.AddedText;
import LAB3.Qualifiers.EncryptedText;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class EncryptionService {

    @Inject
    private CaesarEncryptor caesarEncryptor;

    @Inject
    private ReverseEncryptor reverseEncryptor;

    @Inject
    @EncryptedText
    private Event<String> encryptedTextEvent; // Событие для зашифрованного текста

    public void encryptText(@Observes @AddedText String text) {
        // Применяем шифратор Цезаря
        String caesarEncrypted = caesarEncryptor.encrypt(text);
        encryptedTextEvent.fire(caesarEncrypted); // Генерируем событие для вывода после первого этапа

        // Применяем шифратор переворота текста
        String reverseEncrypted = reverseEncryptor.encrypt(caesarEncrypted);
        encryptedTextEvent.fire(reverseEncrypted); // Генерируем событие для вывода после второго этапа
    }
}
