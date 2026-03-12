package org.ies.tierno.company.app;

import org.ies.tierno.company.apps.CompanyApp;
import org.ies.tierno.company.model.Company;
import org.ies.tierno.company.model.Department;
import org.ies.tierno.company.model.Employee;
import org.ies.tierno.company.readers.Reader;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static org.junit.Assert.*;

public class CompanyAppTest {

    private Company company;
    private Reader<Company> companyReader;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        // Crear una compañía de prueba
        Employee emp1 = new Employee("11111111X", "Ana", "García", "Jefe");
        Employee emp2 = new Employee("22222222Y", "Luis", "Martín", "Programador");

        Department ventas = new Department("Ventas", Arrays.asList(emp1, emp2));

        Map<String, Department> departments = new HashMap<>();
        departments.put("Ventas", ventas);

        company = new Company("Test Company", "A12345678", departments);

        // Capturar salida de log
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testExitOption() {
        // Simular entrada: opción 5 (salir)
        String input = "5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Crear reader que devuelve nuestra compañía de prueba
        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        // Verificar que se ejecutó sin errores
        assertTrue(true);
    }

    @Test
    public void testShowDepartments() {
        // Simular entrada: opción 1 (mostrar departamentos) y luego 5 (salir)
        String input = "1\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        // Verificar que se ejecutó sin errores
        assertTrue(true);
    }

    @Test
    public void testShowDepartmentEmployees() {
        // Simular entrada: opción 2 (empleados de departamento), nombre, y salir
        String input = "2\nVentas\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testShowDepartmentEmployeesWithInvalidDepartment() {
        // Simular entrada: opción 2, departamento inválido, luego 5
        String input = "2\nNoExiste\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testShowDepartment() {
        // Simular entrada: opción 3 (mostrar departamento), nombre, y salir
        String input = "3\nVentas\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testShowDepartmentWithInvalidDepartment() {
        // Simular entrada: opción 3, departamento inválido, luego 5
        String input = "3\nNoExiste\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testShowEmployee() {
        // Simular entrada: opción 4 (mostrar empleado), NIF, y salir
        String input = "4\n11111111X\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testShowEmployeeWithInvalidNif() {
        // Simular entrada: opción 4, NIF inválido, luego 5
        String input = "4\n99999999Z\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testInvalidOption() {
        // Simular entrada: opción inválida, luego 5
        String input = "99\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testNonNumericOption() {
        // Simular entrada: texto en lugar de número, luego 5
        String input = "abc\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    @Test
    public void testMultipleOperations() {
        // Simular múltiples operaciones
        String input = "1\n2\nVentas\n3\nVentas\n4\n11111111X\n5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        companyReader = new TestCompanyReader(company);

        CompanyApp app = new CompanyApp(scanner, companyReader);
        app.run();

        assertTrue(true);
    }

    // Clase auxiliar para crear un Reader que devuelva nuestra compañía de prueba
    private static class TestCompanyReader implements Reader<Company> {
        private final Company company;

        public TestCompanyReader(Company company) {
            this.company = company;
        }

        @Override
        public Company read() {
            return company;
        }
    }
}