package LAB3.Decorators;

import LAB3.Interface.ITextEncryptor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class ReversalEncryptor implements ITextEncryptor {

    @Inject
    @Delegate
    private ITextEncryptor delegate;

    @Override
    public String encrypt(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return delegate.encrypt(reversed);
    }
}
