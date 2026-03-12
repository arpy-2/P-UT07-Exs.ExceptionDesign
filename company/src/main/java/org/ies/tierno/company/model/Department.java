package org.ies.tierno.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
@Data
@AllArgsConstructor
public class Department {
    private String name;
    private List<Employee> employees;

    public void showInfo() {
        log.info("Departamento " + name +". Empleados: ");
        for (var employee: employees) {
            employee.showInfo();
        }
    }
}