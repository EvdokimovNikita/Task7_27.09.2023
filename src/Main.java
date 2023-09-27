import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> aa = new ArrayList<>();

    public static void main(String[] args) {
        /*Задание: Напечатать N первых чисел фибоначчи*/
        System.out.print("Введите количество чисел: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(fibanachchi(number));
    }

    //  Реализация через цикл:
    /*public static void fibanachchi(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        int[] arrNumber = new int[number];
        arrNumber[0] = 0;
        arrNumber[1] = 1;
        for (int i = 2; i < number; ++i) {
            arrNumber[i] = arrNumber[i - 1] + arrNumber[i - 2];
        }
        for (int i = 0; i < arrNumber.length; ++i) {
            System.out.println(arrNumber[i]);
        }
    }
}*/
//  Реализация через рекурсию(не получилось сделать чтобы вывод был всех чисел, выводит только то число индекс
//  которого передал):
    public static int fibanachchi(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (number <= 1) {
            return 0;
        } else if (number == 2) {
            return 1;
        }
        return fibanachchi(number - 1) + fibanachchi(number - 2);
    }
}