package LAB1.Interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class TimeProfilerInterceptor {

    @AroundInvoke
    public Object measureTime(InvocationContext ic) throws Exception {
        long start = System.nanoTime();
        try {
            return ic.proceed();
        } 
        finally {
            long end = System.nanoTime();
            System.out.println("Время выполнения метода: " + (end - start) + " наносекунд"); // Время выполнения метода
        }
    }
}
