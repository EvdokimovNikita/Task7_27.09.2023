import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.println("Array solution:");
        System.out.println(Arrays.toString(fibanachchiArray(number)));

        List<Integer> result = new ArrayList<>();
        System.out.println("No array solution:");
        for (int i = 1; i <= number; i++) {
            result.add(fibanachchiNoArray(i));
        }
        System.out.println(result);

        result.clear();
        System.out.println("Ugly recursion:");
        for (int i = 1; i <= number; i++) {
            result.add(uglyFibanachchiRecursion(i));
        }
        System.out.println(result);
        System.out.println("Recursion stats:");
        // Look at those numbers to understand why ugly recursion is needed:
        // if you call fibanachchi(70) - it will execute forever because amount of calls
        // needed to calculate the result grows exponentially. Even for 40 it's already
        // takes some time to execute.
        // This doesn't mean that you recursion solution is bad, it's just not applicable for
        // Real usage, only as an algorithm demo.
        uglyRecursionCalls = 0;
        uglyFibanachchiRecursion(number);
        System.out.println("Nice: " + niceRecursionCalls);
        System.out.println("Ugly: " + uglyRecursionCalls);
    }

    // Another "single number" solution
    // "Single number" solutions are much worse than "array" solution because they do summing
    // Of same numbers again and again when array solution calculate each number one time.
    public static int fibanachchiNoArray(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Argument should be greater than 0.");
        }
        switch (number) {
            case 1:
                return 0;
            case 2:
                return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i < number; i++) {
            // Looks nice!
            b = a + b;
            a = b - a;
        }
        return b;

    }

    // Your solution is nice, just need to use it a bit better:
    public static int[] fibanachchiArray(int number) {
        // Less than 1! As there's no 0's fibanachchi number.
        if (number < 1) {
            throw new IllegalArgumentException();
        }
        if (number == 1) {
            // Prevent crashing for number=1.
            return new int[] { 0 };
        }
        // Name can be just 'array', or just 'a'.
        int[] arrNumber = new int[number];
        arrNumber[0] = 0;
        arrNumber[1] = 1;
        for (int i = 2; i < number; ++i) {
            arrNumber[i] = arrNumber[i - 1] + arrNumber[i - 2];
        }
        return arrNumber;
    }

    private static int niceRecursionCalls = 0;
//  Реализация через рекурсию(не получилось сделать чтобы вывод был всех чисел, выводит только то число индекс
//  которого передал):
    // You can just call this method in for cycle to print N first numbers.
    public static int fibanachchi(int number) {
        niceRecursionCalls++;
        // Less than 1!
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

    private static int uglyRecursionCalls = 0;
    // One more recursion, really ugly, but requires much fewer calculations than your solution.
    // Anyway your solution is completely fine and much better as the code contains
    // the definition of return fibanachchi(number - 1) + fibanachchi(number - 2).
    // Anyway review the solution to understand how it works.
    public static int uglyFibanachchiRecursion(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        switch (number) {
            case 1:
                return 0;
            case 2:
                return 1;
        }
        return ufr(0, 1, number - 2);
    }

    private static int ufr(int a, int b, int steps) {
        uglyRecursionCalls++;
        if (steps == 0) {
            return b;
        }
        return ufr(b, a + b, steps - 1);
    }
}