package q1;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter a sequence of number pairs.
        System.out.println("Enter pairs of numbers for the first polynomial. For example: 1.5, 2 3.0, 4");
        String input = scanner.nextLine();
        // Splitting the input into pairs
        String[] pairs = input.split("\\s+");

        // Creating arrays for double and int numbers
        double[] dblArr = new double[pairs.length];
        int[] intArr = new int[pairs.length];

        // Filling the arrays
        for (int i = 0; i < pairs.length; i++) {
            String[] pair = pairs[i].split(",");
            dblArr[i] = Double.parseDouble(pair[0].trim());
            intArr[i] = Integer.parseInt(pair[1].trim());
        }
        Polynom p1 = new Polynom(dblArr, intArr);

        System.out.println("Enter pairs of numbers for the second polynomial.");
        input = scanner.nextLine();
        // Splitting the input into pairs
        pairs = input.split("\\s+");

        // Creating arrays for double and int numbers
        dblArr = new double[pairs.length];
        intArr = new int[pairs.length];

        // Filling the arrays
        for (int i = 0; i < pairs.length; i++) {
            String[] pair = pairs[i].split(",");
            dblArr[i] = Double.parseDouble(pair[0].trim());
            intArr[i] = Integer.parseInt(pair[1].trim());
        }

        Polynom p2 = new Polynom(dblArr, intArr);
        Polynom plus = p1.plus(p2);
        Polynom minus = p1.minus(p2);
        Polynom cut1 = p1.derivative();
        Polynom cut2 = p2.derivative();

        System.out.println(p1 + " + " + p2 + " \b= " + plus);
        System.out.println(p1 + " - (" + p2 + ") = " + minus);
        System.out.println("(" + p1 + ")'= " + cut1);
        System.out.println("(" + p2 + ")'= " + cut2);
        System.out.println(p1 + " = " + p2 + " ? " + p1.equals(p2));
    }
}
