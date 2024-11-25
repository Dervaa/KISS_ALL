package LAB3.Encryptors;

import LAB3.Interface.ITextEncryptor;
import LAB3.Qualifiers.Caesar;

import javax.enterprise.context.Dependent;

@Caesar
@Dependent
public class CaesarEncryptor implements ITextEncryptor {
    private final int shift = 3;

    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            result.append(c);
        }
        return result.toString();
    }
}

