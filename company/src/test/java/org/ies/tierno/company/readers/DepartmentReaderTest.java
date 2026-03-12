package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Department;
import org.ies.tierno.company.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class DepartmentReaderTest {

    private DepartmentReader departmentReader;
    private EmployeeReader employeeReader;
    private Random random;

    @Before
    public void setUp() {
        random = new Random();
        employeeReader = new EmployeeReader(random);
        departmentReader = new DepartmentReader(random, employeeReader);
    }

    @Test
    public void testRead() {
        Department department = departmentReader.read();

        assertNotNull(department);
        assertNotNull(department.getName());
        assertNotNull(department.getEmployees());
        assertTrue(department.getEmployees().size() >= 1 && department.getEmployees().size() <= 9);

        // Verificar nombre del departamento
        assertTrue(department.getName().startsWith("Departamento "));
    }

    @Test
    public void testReadMultipleDepartments() {
        Department dept1 = departmentReader.read();
        Department dept2 = departmentReader.read();

        assertNotNull(dept1);
        assertNotNull(dept2);
    }

    @Test
    public void testDepartmentEmployeesAreValid() {
        Department department = departmentReader.read();

        for (Employee employee : department.getEmployees()) {
            assertNotNull(employee.getNif());
            assertNotNull(employee.getName());
            assertNotNull(employee.getSurname());
            assertNotNull(employee.getRole());
        }
    }

    @Test
    public void testDepartmentNamesAreDifferent() {
        Set<String> names = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            Department dept = departmentReader.read();
            names.add(dept.getName());
        }

        // Puede que a veces se repitan, pero generalmente serán diferentes
        assertTrue("Debería haber al menos 2 nombres diferentes", names.size() > 1);
    }
}