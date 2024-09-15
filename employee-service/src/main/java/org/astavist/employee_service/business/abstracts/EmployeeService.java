package org.astavist.employee_service.business.abstracts;

import org.astavist.employee_service.business.dto.requests.CreateEmployeeRequest;
import org.astavist.employee_service.business.dto.requests.UpdateEmployeeRequest;
import org.astavist.employee_service.business.dto.responses.CreateEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.GetAllEmployeesResponse;
import org.astavist.employee_service.business.dto.responses.GetEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.UpdateEmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<GetAllEmployeesResponse> getAll();

    GetEmployeeResponse getById(UUID id);

    CreateEmployeeResponse add(CreateEmployeeRequest request);

    UpdateEmployeeResponse update(UUID id, UpdateEmployeeRequest request);

    void delete(UUID id);
}
