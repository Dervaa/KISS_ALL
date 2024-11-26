package LAB1.GcdMethods;

import LAB1.Interface.IGcdCalculator;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Alternative;

//@ApplicationScoped
@Alternative
@Priority(2)
public class PrimeFactorizationGcd implements IGcdCalculator {

    @Override
    public int calculateGcd(int a, int b) {
        System.out.println("Запуск разложения на простые множители...");
        List<Integer> factorsA = primeFactors(a);
        List<Integer> factorsB = primeFactors(b);
        return computeGcdFromFactors(factorsA, factorsB);
    }

    private List<Integer> primeFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }

    private int computeGcdFromFactors(List<Integer> factorsA, List<Integer> factorsB) {
        int gcd = 1;
        for (Integer factor : factorsA) {
            if (factorsB.contains(factor)) {
                gcd *= factor;
                factorsB.remove(factor);
            }
        }
        return gcd;
    }
}
