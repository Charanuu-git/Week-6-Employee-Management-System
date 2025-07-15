package employeeManagement.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee model (Plain Java Object)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @NotBlank(message = "Position is mandatory")
    private String position;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;
}
