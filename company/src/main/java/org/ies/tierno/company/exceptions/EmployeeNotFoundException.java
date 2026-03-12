package org.ies.tierno.company.exceptions;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends Exception{
    private final String nif;

    public EmployeeNotFoundException(String nif) {
        super(nif);
        this.nif = nif;
    }

}