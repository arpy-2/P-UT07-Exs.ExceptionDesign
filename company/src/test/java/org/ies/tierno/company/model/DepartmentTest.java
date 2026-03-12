package org.ies.tierno.company.model;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void testDepartmentCreation() {
        List<Employee> employees = Arrays.asList(
                new Employee("11111111X", "Ana", "García", "Jefe"),
                new Employee("22222222Y", "Luis", "Martín", "Peón")
        );

        Department department = new Department("Ventas", employees);

        assertEquals("Ventas", department.getName());
        assertEquals(2, department.getEmployees().size());
    }

    @Test
    public void testShowInfo() {
        Department department = new Department("Ventas",
                List.of(new Employee("11111111X", "Ana", "García", "Jefe")));

        department.showInfo();
    }
}