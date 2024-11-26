package LAB1.GcdMethods;

//import LAB1.Annotation.EUCLIDEAN;
import LAB1.Interface.IGcdCalculator;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;



//@Default

//@ApplicationScoped
 @Alternative
 @Priority(1)
// @EUCLIDEAN
public class EuclideanGcd implements IGcdCalculator {

    @Override
    public int calculateGcd(int a, int b) {
        System.out.println("Запуск алгоритма Евклида...");
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
