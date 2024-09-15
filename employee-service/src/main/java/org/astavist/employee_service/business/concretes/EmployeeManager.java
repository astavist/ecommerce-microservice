package org.astavist.employee_service.business.concretes;

import lombok.AllArgsConstructor;
import org.astavist.employee_service.business.abstracts.EmployeeService;
import org.astavist.employee_service.business.dto.requests.CreateEmployeeRequest;
import org.astavist.employee_service.business.dto.requests.UpdateEmployeeRequest;
import org.astavist.employee_service.business.dto.responses.CreateEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.GetAllEmployeesResponse;
import org.astavist.employee_service.business.dto.responses.GetEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.UpdateEmployeeResponse;
import org.astavist.employee_service.entity.Employee;
import org.astavist.employee_service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public List<GetAllEmployeesResponse> getAll() {
        List<Employee> employees = repository.findAll();

        List<GetAllEmployeesResponse> response = new ArrayList<>();
        for (Employee employee : employees) {
            GetAllEmployeesResponse response1 = new GetAllEmployeesResponse();
            response1.setName(employee.getName());
            response1.setId(employee.getId());
            response1.setSalary(employee.getSalary());
            response.add(response1);
        }
        return response;
    }

    @Override
    public GetEmployeeResponse getById(UUID id) {
        var employee = repository.findById(id).orElseThrow();
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setId(employee.getId());
        response.setSalary(employee.getSalary());
        response.setName(employee.getName());
        return response;
    }

    @Override
    public CreateEmployeeResponse add(CreateEmployeeRequest request) {
        var employee = new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setId(UUID.randomUUID());
        repository.save(employee);

        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setSalary(employee.getSalary());

        return response;

    }

    @Override
    public UpdateEmployeeResponse update(UUID id, UpdateEmployeeRequest request) {
        var employee2 = new Employee();
        employee2.setName(request.getName());
        employee2.setSalary(request.getSalary());
        employee2.setId(id);
        repository.save(employee2);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setId(employee2.getId());
        response.setName(employee2.getName());
        response.setSalary(employee2.getSalary());

        return response;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
