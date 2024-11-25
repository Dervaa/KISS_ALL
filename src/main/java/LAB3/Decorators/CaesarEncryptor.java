package LAB3.Decorators;

import LAB3.Interface.ITextEncryptor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Decorator
public class CaesarEncryptor implements ITextEncryptor {

    private final int shift = 3;

    @Inject
    @Delegate
    private ITextEncryptor delegate;

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
        return delegate.encrypt(result.toString());
    }
}
