package kz.dar.university.company.api.controller;

import kz.dar.university.company.api.feign.EmployeeClient;
import kz.dar.university.company.api.model.EmployeeDTO;
import kz.dar.university.company.api.model.task.TaskResponse;
import kz.dar.university.company.api.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private ICompanyService companyService;

    @GetMapping("/check")
    public String check() {
        return "company-api is working";
    }

    @GetMapping("/employee/check")
    public String employeeCheck() {

        return employeeClient.checkEmployeeApi();

    }

    @GetMapping("/employee/list")
    public List<EmployeeDTO> getAllEmployees() {

        return employeeClient.getAllEmployees();

    }

    @GetMapping("/employee/filter")
    public List<EmployeeDTO> filterEmployees() {

        return companyService.filterEmployees();

    }

    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable String employeeId) {

        return employeeClient.getEmployeeById(employeeId);

    }

    @GetMapping("/task/all")
    public List<TaskResponse> getAllTasksWithFullInfo() {

        return companyService.getAllTasksWithFullInfo();

    }

}
