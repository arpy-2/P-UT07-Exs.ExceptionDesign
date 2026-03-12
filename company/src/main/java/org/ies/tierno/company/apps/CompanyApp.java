package org.ies.tierno.company.apps;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.ies.tierno.company.exceptions.DepartmentNotFoundException;
import org.ies.tierno.company.exceptions.EmployeeNotFoundException;
import org.ies.tierno.company.model.Company;
import org.ies.tierno.company.readers.Reader;

import java.util.InputMismatchException;
import java.util.Scanner;

@Log4j
@AllArgsConstructor
public class CompanyApp {
    private final Scanner scanner;
    private final Reader<Company> companyReader;

    public void run() {
        Company company = companyReader.read();

        int opt;
        do {
            opt = chooseOption();

            if (opt == 1) {
                company.showDepartments();
            } else if (opt == 2) {
                runOpt2(company);
            } else if (opt == 3) {
                runOpt3(company);
            } else if (opt == 4) {
                runOpt4(company);
            }

        } while (opt != 5);
    }

    private void runOpt4(Company company) {
        try {
            log.info("Introduce el NIF del empleado");
            String nif = scanner.nextLine();
            var employee = company.findEmployee(nif);
            employee.showInfo();
        } catch (EmployeeNotFoundException e) {
            log.error("No se ha encontrado el empleado: " + e.getNif());
        }
    }

    private void runOpt3(Company company) {
        try {
            log.info("Introduce el nombre del departamento");
            String departmentName = scanner.nextLine();
            var department = company.getDepartment(departmentName);
            department.showInfo();
        } catch (DepartmentNotFoundException e) {
            log.error("No se ha encontrado el departamento: " + e.getDepartmentName());
        }
    }

    private void runOpt2(Company company) {
        try {
            log.info("Introduce el nombre del departamento");
            String departmentName = scanner.nextLine();
            var employees = company.getDepartmentEmployees(departmentName);
            employees.forEach(employee -> employee.showInfo());
        } catch (DepartmentNotFoundException e) {
            log.error("No se ha encontrado el departamento: " + e.getDepartmentName());
        }
    }

    private int chooseOption() {
        Integer opt = null;
        do {
            log.info("Elige una opción:");
            log.info("1. Mostrar departamentos");
            log.info("2. Mostrar empleados de departamento");
            log.info("3. Mostrar departamento");
            log.info("4. Mostrar empleado");
            log.info("5. Salir");

            try {
                opt = scanner.nextInt();
            } catch (InputMismatchException e) {
                log.error("Opción inválida");
            } finally {
                scanner.nextLine();
            }
        } while (opt == null);
        return opt;
    }
}