package LAB1;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import LAB1.Component.GcdCalculator;

import java.util.Scanner;

public class lab1Start {
    protected static Weld weld;
    protected static WeldContainer container;
    public static void main(String[] args) throws Exception {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
       
       try{
        GcdCalculator gcdCalculator = container.select(GcdCalculator.class).get();// get() - получение экземпляра класса
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt(); // Чтение первого числа

        System.out.print("Введите второе число: ");
        int b = scanner.nextInt(); // Чтение второго числа
        scanner.close();// закрытие потока
        
        int gcdResult = gcdCalculator.calculateGcd(a, b);// вызов метода класса

        System.out.println("Наибольший общий делитель для чисел: "+ a + " и " + b + " равен " + gcdResult);// вывод результата
       }
       finally {
        weld.shutdown();
        }
    }
}
