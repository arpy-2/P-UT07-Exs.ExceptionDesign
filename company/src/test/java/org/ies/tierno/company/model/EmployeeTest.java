package org.ies.tierno.company.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    @Test
    public void testEmployeeCreation() {
        Employee employee = new Employee("12345678X", "Juan", "Pérez", "Programador");

        assertEquals("12345678X", employee.getNif());
        assertEquals("Juan", employee.getName());
        assertEquals("Pérez", employee.getSurname());
        assertEquals("Programador", employee.getRole());
    }

    @Test
    public void testShowInfo() {
        Employee employee = new Employee("12345678X", "Juan", "Pérez", "Programador");
        // Este test verificaría que no lanza excepción al ejecutar showInfo()
        employee.showInfo();
    }
}