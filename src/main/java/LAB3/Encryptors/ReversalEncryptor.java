package LAB3.Encryptors;

import LAB3.Interface.ITextEncryptor;
import LAB3.Qualifiers.Reverse;

import javax.enterprise.context.Dependent;

@Reverse
@Dependent
public class ReversalEncryptor implements ITextEncryptor {
    @Override
    public String encrypt(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
