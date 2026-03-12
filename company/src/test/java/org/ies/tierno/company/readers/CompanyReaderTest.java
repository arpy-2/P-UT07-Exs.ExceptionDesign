package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Company;
import org.ies.tierno.company.model.Department;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class CompanyReaderTest {

    private CompanyReader companyReader;
    private DepartmentReader departmentReader;
    private EmployeeReader employeeReader;
    private Random random;

    @Before
    public void setUp() {
        random = new Random();
        employeeReader = new EmployeeReader(random);
        departmentReader = new DepartmentReader(random, employeeReader);
        companyReader = new CompanyReader(random, departmentReader);
    }

    @Test
    public void testRead() {
        Company company = companyReader.read();

        assertNotNull(company);
        assertNotNull(company.getName());
        assertNotNull(company.getCif());
        assertNotNull(company.getDepartmentsByName());

        // Verificar nombre
        assertTrue(company.getName().startsWith("Company "));

        // Verificar CIF (formato: A + 8 dígitos)
        assertTrue(company.getCif().matches("A\\d{8}"));

        // Verificar número de departamentos (1-9)
        int numDepts = company.getDepartmentsByName().size();
        assertTrue(numDepts >= 1 && numDepts <= 9);
    }

    @Test
    public void testReadMultipleCompanies() {
        Company company1 = companyReader.read();
        Company company2 = companyReader.read();

        assertNotNull(company1);
        assertNotNull(company2);
    }

    @Test
    public void testCompanyDepartmentsAreValid() {
        Company company = companyReader.read();

        for (Department department : company.getDepartmentsByName().values()) {
            assertNotNull(department.getName());
            assertNotNull(department.getEmployees());
            assertFalse(department.getEmployees().isEmpty());
        }
    }

    @Test
    public void testNoDuplicateDepartmentNames() {
        Company company = companyReader.read();

        // Los departamentos se guardan en un Map por nombre, así que no puede haber duplicados
        assertEquals(company.getDepartmentsByName().size(),
                company.getDepartmentsByName().keySet().size());
    }
}