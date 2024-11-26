package LAB1.Component;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

// import com.example.Annotation.EUCLIDEAN;
//import LAB1.Annotation.EUCLIDEAN;
import LAB1.Interface.IGcdCalculator;
import LAB1.Interceptors.TimeProfilerInterceptor;

@Interceptors(TimeProfilerInterceptor.class)
public class GcdCalculator {
    @Inject
//    @EUCLIDEAN
    private IGcdCalculator gcdCalculator;
    public int calculateGcd(int a, int b){
        return gcdCalculator.calculateGcd(a, b);
    }
}
