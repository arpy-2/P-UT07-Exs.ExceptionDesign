package org.ies.tierno.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.company.exceptions.DepartmentNotFoundException;
import org.ies.tierno.company.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String, Department> departmentsByName;

    public void showDepartments() {
        for (var department : departmentsByName.values()) {
            department.showInfo();
        }
    }

    public List<Employee> getDepartmentEmployees(String departmentName) throws DepartmentNotFoundException {
        return getDepartment(departmentName).getEmployees();
    }

    public Department getDepartment(String departmentName) throws DepartmentNotFoundException {
        if (departmentsByName.containsKey(departmentName)) {
            return departmentsByName.get(departmentName);
        }
        throw new DepartmentNotFoundException(departmentName);
    }

    public Employee findEmployee(String nif) throws EmployeeNotFoundException {
//        for(var department: departmentsByName.values()) {
//            for(var employee: department.getEmployees()){
//                if(employee.getNif().equals(nif)) {
//                    return employee;
//                }
//            }
//        }
//        throw new EmployeeNotFoundException(nif);
        return departmentsByName
                .values().stream()
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getNif().equals(nif))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(nif));
    }
}