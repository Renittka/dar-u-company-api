package kz.dar.university.company.api.service;

import kz.dar.university.company.api.model.EmployeeDTO;
import kz.dar.university.company.api.model.task.TaskResponse;

import java.util.List;

public interface ICompanyService {

    List<EmployeeDTO> filterEmployees();

    List<TaskResponse> getAllTasksWithFullInfo();

}
