package Polynomial;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter Value of x: ");
        Scanner input = new Scanner(System.in);

        NewtonForward newton_forward_polynomial = new NewtonForward();
        newton_forward_polynomial.generatePolynomial(input.nextDouble());
    }
}
