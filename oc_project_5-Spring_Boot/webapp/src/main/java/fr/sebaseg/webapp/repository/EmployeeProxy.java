package fr.sebaseg.webapp.repository;

import fr.sebaseg.webapp.CustomProperties;
import fr.sebaseg.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Employee> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        log.debug("Get Employees call {}", response.getStatusCode());

        return response.getBody();
    }

    public Employee createEmployee(Employee e) {
        String baseApiUrl = props.getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Employee.class
        );

        log.debug("Create Employee call {}", response.getStatusCode());

        return response.getBody();
    }

    public Employee getEmployee(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Employee.class
        );

        log.debug("Get Employee call {}", response.getStatusCode());

        return response.getBody();
    }

    public void deleteEmployee(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        log.debug("Delete Employee call {}", response.getStatusCode());
    }

    public Employee updateEmployee(Employee employee) {
        String baseApiUrl = props.getApiUrl();
        String updateEmployeeUrl = baseApiUrl + "/employee/" + employee.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Employee.class
        );

        log.debug("Update Employee call {}", response.getStatusCode());

        return response.getBody();
    }
}
