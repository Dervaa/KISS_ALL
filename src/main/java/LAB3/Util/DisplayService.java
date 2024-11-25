package LAB3.Util;

import LAB3.Qualifiers.EncryptedText;

import javax.enterprise.event.Observes;

public class DisplayService {

    public void displayEncryptedText(@Observes @EncryptedText String encryptedText) {
        System.out.println("Зашифрованный текст: " + encryptedText);
    }
}
