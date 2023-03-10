package kz.dar.university.company.api.model.task;

import kz.dar.university.company.api.model.employee.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {

    private String taskId;
    private String description;
    private EmployeeDTO initiator;
    private EmployeeDTO executor;

}
