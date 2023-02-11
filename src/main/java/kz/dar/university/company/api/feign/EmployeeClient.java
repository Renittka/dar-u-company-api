package kz.dar.university.company.api.feign;

import kz.dar.university.company.api.model.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "employee-core-api")
public interface EmployeeClient {

    @GetMapping("/employee/check")
    String checkEmployeeApi();

    @GetMapping("/employee/all")
    List<EmployeeDTO> getAllEmployees();

    @GetMapping("/employee")
    EmployeeDTO getEmployeeById(@RequestParam String employeeId);

    /*
    @GetMapping("/employee/{employeeId}")
    EmployeeDTO getEmployeeByIdPath(@PathVariable String employeeId);
     */

}
