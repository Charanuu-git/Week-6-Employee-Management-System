package employeeManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import employeeManagement.model.Employee;
import employeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        log.info("Fetching employee with id {}", id);
        return service.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee emp) {
        log.info("Creating employee: {}", emp.getName());
        return ResponseEntity.ok(service.createEmployee(emp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee emp) {
        log.info("Updating employee id {}: {}", id, emp.getName());
        return ResponseEntity.ok(service.updateEmployee(id, emp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        log.info("Deleting employee id {}", id);
        return ResponseEntity.ok(service.deleteEmployee(id));
    }

    @GetMapping("/filter-by-salary")
    public List<Employee> filterBySalary(@RequestParam double minSalary) {
        log.info("Filtering employees with salary >= {}", minSalary);
        return service.filterBySalary(minSalary);
    }

    @GetMapping("/group-by-dept")
    public Map<String, List<Employee>> groupByDept() {
        log.info("Grouping employees by department");
        return service.groupByDepartment();
    }
}
