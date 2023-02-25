package kz.dar.university.company.api.service;

import kz.dar.university.company.api.feign.EmployeeClient;
import kz.dar.university.company.api.feign.TaskClient;
import kz.dar.university.company.api.model.employee.EmployeeDTO;
import kz.dar.university.company.api.model.task.TaskDTO;
import kz.dar.university.company.api.model.task.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private TaskClient taskClient;

    @Override
    public List<EmployeeDTO> filterEmployees() {

        List<EmployeeDTO> allEmployees = employeeClient.getAllEmployees();
        List<EmployeeDTO> result = new ArrayList<>();
        for (EmployeeDTO employee : allEmployees) {
            if (employee.getSalary() < 100000) {
                result.add(employee);
            }
        }

        return result;
    }

    @Override
    public List<TaskResponse> getAllTasksWithFullInfo() {

        List<TaskResponse> result = new ArrayList<>();

        // 1. Получить информацию о всех тасках
        List<TaskDTO> taskList = taskClient.getAllTasks();

        for (TaskDTO task : taskList) {
            // 2. Получить информацию о сотруднике по ID из таска
            String initiatorId = task.getInitiatorId();
            String executorId = task.getExecutorId();

            EmployeeDTO initiator = employeeClient.getEmployeeById(initiatorId);
            EmployeeDTO executor = employeeClient.getEmployeeById(executorId);

            // 3. Сопоставить информацию о сотруднике и таске
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setTaskId(task.getTaskId());
            taskResponse.setDescription(task.getDescription());
            taskResponse.setInitiator(initiator);
            taskResponse.setExecutor(executor);

            result.add(taskResponse);
        }

        // 4. Вывести детальную информацию о тасках
        return result;

    }

}
