package LAB3.Util;

import LAB3.Interface.ITextEncryptor;
import LAB3.Qualifiers.AddedText;
import LAB3.Qualifiers.Caesar;
import LAB3.Qualifiers.EncryptedText;
import LAB3.Qualifiers.Reverse;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class EncryptionService {

    @Inject
    @Caesar
    private ITextEncryptor caesarEncryptor;

    @Inject
    @Reverse
    private ITextEncryptor reverseEncryptor;

    @Inject
    @EncryptedText
    private Event<String> encryptedTextEvent; // Событие для передачи зашифрованного текста

    public void encryptText(@Observes @AddedText String text) {
        // Последовательно применяем шифраторы
        String encrypted = caesarEncryptor.encrypt(text);  // Шифруем текст шифром Цезаря
        encrypted = reverseEncryptor.encrypt(encrypted);  // Переворачиваем текст

        // Генерируем событие с финальным зашифрованным текстом
        encryptedTextEvent.fire(encrypted);
    }
}
