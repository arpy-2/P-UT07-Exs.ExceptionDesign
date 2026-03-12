package org.ies.tierno.company;

import lombok.extern.log4j.Log4j;
import org.ies.tierno.company.apps.CompanyApp;
import org.ies.tierno.company.readers.CompanyReader;
import org.ies.tierno.company.readers.DepartmentReader;
import org.ies.tierno.company.readers.EmployeeReader;

import java.util.Random;
import java.util.Scanner;

@Log4j
public class Main {
    public static void main(String[] args) {
        var random = new Random();
        var employeeReader = new EmployeeReader(random);
        var departmentReader = new DepartmentReader(random, employeeReader);
        var companyReader = new CompanyReader(random, departmentReader);

        var scanner = new Scanner(System.in);
        var companyApp = new CompanyApp(scanner, companyReader);

        companyApp.run();
    }
}