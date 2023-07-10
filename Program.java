import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Program {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        task4();
    }

    /** 
        Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
        и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
        вместо этого, необходимо повторно запросить у пользователя ввод данных.
    **/

    public static void task1(){
        try {
            System.out.printf("Введенное значение: %f", inputFloatNumber());
        } catch (MyInputException e) {
            System.out.printf("Внимание ошибка!\n%s", e.getMessage());
            task1();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static float inputFloatNumber() throws MyInputException{
        try {
            System.out.println("\nВведите число с плавающей точкой:");
            float number = Float.parseFloat(sc.nextLine());
            return number;
        }
        catch(NumberFormatException e){
            throw new MyInputException("Введенное значение не может быть типом float!!!!");
        }
    }

    public static void task2(){
        try {
            int[] intArray = new int[rand.nextInt(15)]; 
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         } catch (IndexOutOfBoundsException e){
            System.out.println("Ошибка с размерностью массива!\n" + e);
         }     
    }

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (FileNotFoundException ex) {
            System.out.println("Не удалось найти путь");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }

    /**
        Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    **/

    public static void task4() {
        try{
            System.out.println("введите строку:");
            String str = sc.nextLine();
            outputString(str);
        } catch (MyNullStringException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void outputString(String str) throws MyNullStringException {
        if (str.length() == 0)
            throw new MyNullStringException("Запрещено вводить нулевые строки. Повторите попытку!");
        System.out.println("Длина введенной строки равна " + str.length());
    }
}



abstract class MyException extends Exception{

    public MyException(String str){
        super(str);
    }
}

class MyInputException extends MyException{

    public MyInputException(String str){
        super(str);
    }
}

class MyNullStringException extends MyException{

    public MyNullStringException(String str){
        super(str);
    }

}
