package kz.dar.university.company.api.service;

import kz.dar.university.company.api.feign.EmployeeClient;
import kz.dar.university.company.api.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private EmployeeClient employeeClient;

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

}
