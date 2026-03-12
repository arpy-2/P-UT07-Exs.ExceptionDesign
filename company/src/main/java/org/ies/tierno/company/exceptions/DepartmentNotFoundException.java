package org.ies.tierno.company.exceptions;

import lombok.Getter;

@Getter
public class DepartmentNotFoundException extends Exception{
    private final String departmentName;

    public DepartmentNotFoundException(String departmentName) {
        this.departmentName = departmentName;
    }

}