package kz.dar.university.company.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String employeeId;
    private String name;
    private String surname;
    private String companyId;
    private String position;
    private String email;
    private double salary;

}
