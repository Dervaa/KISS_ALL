package LAB3.Util;

import LAB3.Interface.ITextEncryptor;
import LAB3.Qualifiers.AddedText;
import LAB3.Qualifiers.EncryptedText;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.List;

public class EncryptionService {

    @Inject
    private List<ITextEncryptor> encryptors;

    @Inject
    @EncryptedText
    private Event<String> encryptedTextEvent;

    public void encryptText(@Observes @AddedText String text) {
        String encrypted = text;
        for (ITextEncryptor encryptor : encryptors) {
            encrypted = encryptor.encrypt(encrypted);
        }
        encryptedTextEvent.fire(encrypted);
    }
}
