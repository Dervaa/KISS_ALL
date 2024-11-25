package LAB3.Util;

import LAB3.Interface.ITextEncryptor;

import javax.enterprise.context.Dependent;

@Dependent
public class ReverseEncryptor implements ITextEncryptor {

    @Override
    public String encrypt(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
