package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Employee;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import static org.junit.Assert.*;

public class EmployeeReaderTest {

    private EmployeeReader employeeReader;
    private Random random;

    @Before
    public void setUp() {
        random = new Random();
        employeeReader = new EmployeeReader(random);
    }

    @Test
    public void testRead() {
        Employee employee = employeeReader.read();

        assertNotNull(employee);
        assertNotNull(employee.getNif());
        assertNotNull(employee.getName());
        assertNotNull(employee.getSurname());
        assertNotNull(employee.getRole());

        // Verificar formato del NIF (8 números y una letra)
        String nif = employee.getNif();
        assertTrue(nif.matches("\\d{8}[A-Z]"));
    }

    @Test
    public void testMultipleReads() {
        Employee employee1 = employeeReader.read();
        Employee employee2 = employeeReader.read();

        assertNotNull(employee1);
        assertNotNull(employee2);
    }

    @Test
    public void testReadGeneratesDifferentEmployees() {
        Set<String> nifs = new HashSet<>();

        // Leer varios empleados
        for (int i = 0; i < 10; i++) {
            Employee employee = employeeReader.read();
            nifs.add(employee.getNif());
        }

        // Debería generar NIFs diferentes (o al menos no todos iguales)
        assertTrue(nifs.size() > 1);
    }

    @Test
    public void testNamesFromValidList() {
        Employee employee = employeeReader.read();

        // Verificar que el nombre está en la lista de nombres válidos
        String[] validNames = {"Bob", "Peppa", "George", "Pepe", "María", "Ana"};
        boolean validName = false;
        for (String name : validNames) {
            if (name.equals(employee.getName())) {
                validName = true;
                break;
            }
        }
        assertTrue("El nombre debería estar en la lista de nombres válidos", validName);
    }

    @Test
    public void testSurnamesFromValidList() {
        Employee employee = employeeReader.read();

        String[] validSurnames = {"Esponja", "Pig", "Pérez", "Sánchez", "López"};
        boolean validSurname = false;
        for (String surname : validSurnames) {
            if (surname.equals(employee.getSurname())) {
                validSurname = true;
                break;
            }
        }
        assertTrue("El apellido debería estar en la lista de apellidos válidos", validSurname);
    }

    @Test
    public void testRolesFromValidList() {
        Employee employee = employeeReader.read();

        String[] validRoles = {"Jefe", "Peón", "Senior", "Programador", "Recruiter"};
        boolean validRole = false;
        for (String role : validRoles) {
            if (role.equals(employee.getRole())) {
                validRole = true;
                break;
            }
        }
        assertTrue("El rol debería estar en la lista de roles válidos", validRole);
    }
}