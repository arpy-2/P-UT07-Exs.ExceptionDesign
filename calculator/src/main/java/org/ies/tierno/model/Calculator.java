package org.ies.tierno.model;

import org.ies.tierno.model.exceptions.DivideByZeroException;
import org.ies.tierno.model.exceptions.EmptyListException;

import java.util.List;

public class Calculator {

    public double divide(double a, double b) throws DivideByZeroException {

        if (b == 0) {
            throw new DivideByZeroException("No se puede dividir entre 0");
        }

        return a / b;
    }

    public double media(List<Double> numbers) throws EmptyListException {

        if (numbers.isEmpty()) {
            throw new EmptyListException("La lista está vacía");
        }

        double suma = 0;

        for (double n : numbers) {
            suma += n;
        }

        return suma / numbers.size();
    }
}