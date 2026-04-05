package fr.sebaseg.api.controller;

import fr.sebaseg.api.model.Employee;
import fr.sebaseg.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * Create - Add a new employee
     * @param employee An object employee
     * @return The employee created
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Read - Get an employee by id
     * @param id - The id of the employee
     * @return - An object employee
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);

        return employee.orElse(null);
    }

    /**
     * Read - Get all employees
     * @return - An iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);

        if (e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if (firstName != null) {
                currentEmployee.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if (lastName != null) {
                currentEmployee.setLastName(lastName);
            }

            String mail = employee.getMail();
            if (mail != null) {
                currentEmployee.setMail(mail);
            }

            String password = employee.getPassword();
            if (password != null) {
                currentEmployee.setPassword(password);
            }

            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else {
            return null;
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable final Long id) {
        employeeService.deleteEmployee(id);
    }
}
