package org.ies.tierno.company.model;

import org.ies.tierno.company.exceptions.DepartmentNotFoundException;
import org.ies.tierno.company.exceptions.EmployeeNotFoundException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class CompanyTest {

    private Company company;
    private Department ventas;
    private Department informatica;
    private Employee empleado1;
    private Employee empleado2;

    @Before
    public void setUp() {
        empleado1 = new Employee("11111111X", "Ana", "García", "Jefe");
        empleado2 = new Employee("22222222Y", "Luis", "Martín", "Programador");
        Employee empleado3 = new Employee("33333333Z", "Carlos", "López", "Analista");

        ventas = new Department("Ventas", Arrays.asList(empleado1, empleado2));
        informatica = new Department("Informática", Arrays.asList(empleado3));

        Map<String, Department> departments = new HashMap<>();
        departments.put("Ventas", ventas);
        departments.put("Informática", informatica);

        company = new Company("Test Company", "A12345678", departments);
    }

    @Test
    public void testGetDepartmentExists() throws DepartmentNotFoundException {
        Department result = company.getDepartment("Ventas");
        assertEquals(ventas, result);
    }

    @Test(expected = DepartmentNotFoundException.class)
    public void testGetDepartmentNotFound() throws DepartmentNotFoundException {
        company.getDepartment("NoExiste");
    }

    @Test
    public void testGetDepartmentEmployeesExists() throws DepartmentNotFoundException {
        List<Employee> employees = company.getDepartmentEmployees("Ventas");
        assertEquals(2, employees.size());
        assertTrue(employees.contains(empleado1));
        assertTrue(employees.contains(empleado2));
    }

    @Test(expected = DepartmentNotFoundException.class)
    public void testGetDepartmentEmployeesNotFound() throws DepartmentNotFoundException {
        company.getDepartmentEmployees("NoExiste");
    }

    @Test
    public void testFindEmployeeExists() throws EmployeeNotFoundException {
        Employee result = company.findEmployee("11111111X");
        assertEquals(empleado1, result);
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void testFindEmployeeNotFound() throws EmployeeNotFoundException {
        company.findEmployee("99999999Z");
    }

    @Test
    public void testShowDepartments() {
        // Verificar que no lanza excepción
        company.showDepartments();
    }
}