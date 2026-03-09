package org.ies.tierno;

import org.ies.tierno.model.*;
import org.ies.tierno.model.exceptions.DivideByZeroException;
import org.ies.tierno.model.exceptions.EmptyListException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        int selectedOption;

        do {

            System.out.println("CALCULADORA");
            System.out.println("1. Dividir");
            System.out.println("2. Calcular media");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            selectedOption = inputScanner.nextInt();

            switch (selectedOption) {

                case 1:
                    try {
                        System.out.print("Introduce el primer número: ");
                        double firstNumber = inputScanner.nextDouble();

                        System.out.print("Introduce el segundo número: ");
                        double secondNumber = inputScanner.nextDouble();

                        double divisionResult = calculator.divide(firstNumber, secondNumber);

                        System.out.println("Resultado: " + divisionResult);

                    } catch (DivideByZeroException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;

                case 2:
                    try {

                        List<Double> numberList = new ArrayList<>();

                        System.out.print("¿Cuántos números quieres introducir?: ");
                        int totalNumbers = inputScanner.nextInt();

                        for (int counter = 0; counter < totalNumbers; counter++) {
                            System.out.print("Número " + (counter + 1) + ": ");
                            numberList.add(inputScanner.nextDouble());
                        }

                        double averageResult = calculator.media(numberList);

                        System.out.println("La media es: " + averageResult);

                    } catch (EmptyListException exception) {
                        System.out.println(exception.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (selectedOption != 0);
    }
}