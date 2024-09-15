package org.astavist.employee_service.business.consumer;

import org.astavist.employee_service.business.abstracts.EmployeeService;
import org.astavist.employee_service.business.dto.requests.UpdateEmployeeRequest;
import org.astavist.employee_service.entity.Employee;
import org.astavist.employee_service.repository.EmployeeRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RabbitMQConsumer {
    @Autowired
    private EmployeeRepository repository;

    @RabbitListener(queues = "employee_payment_queue")
    public void receivedMessage(UUID message){
        Employee employee = repository.findById(message).orElseThrow();
        employee.setPaid(true);
        employee.setId(message);
        repository.save(employee);
    }
}
