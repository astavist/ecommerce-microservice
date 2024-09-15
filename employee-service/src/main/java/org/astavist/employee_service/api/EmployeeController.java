package org.astavist.employee_service.api;

import lombok.AllArgsConstructor;
import org.astavist.employee_service.business.abstracts.EmployeeService;
import org.astavist.employee_service.business.consumer.RabbitMQConsumer;
import org.astavist.employee_service.business.dto.requests.CreateEmployeeRequest;
import org.astavist.employee_service.business.dto.requests.UpdateEmployeeRequest;
import org.astavist.employee_service.business.dto.responses.CreateEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.GetAllEmployeesResponse;
import org.astavist.employee_service.business.dto.responses.GetEmployeeResponse;
import org.astavist.employee_service.business.dto.responses.UpdateEmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public List<GetAllEmployeesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetEmployeeResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeResponse add(@RequestBody CreateEmployeeRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateEmployeeResponse update(@PathVariable UUID id, @RequestBody UpdateEmployeeRequest request) {
        return service.update(id, request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
