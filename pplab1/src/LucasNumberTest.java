import java.util.Scanner;

public class LucasNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть номер числа Люка (n): ");
        int n = scanner.nextInt();

        LucasNumber lucasNumber = new LucasNumber(n);

        System.out.println("L_" + n + " = " + lucasNumber.getValue());

        if (lucasNumber.checkInequality()) {
            System.out.println("Нерівність " + n + "L_{" + (n+1) + "} > (" + (n+1) + ")L_{" + n + "} виконується.");
        } else {
            System.out.println("Нерівність " + n + "L_{" + (n+1) + "} > (" + (n+1) + ")L_{" + n + "} не виконується.");
        }

        scanner.close();
    }
}
